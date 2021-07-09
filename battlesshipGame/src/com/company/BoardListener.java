package com.company;

import sun.net.ftp.FtpDirEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static sun.security.util.ObjectIdentifier.pack;

private class BoardListener implements ActionListener
{
    private int ready;

    public void actionPerformed(ActionEvent v)
    {
        if (ready==0)
        {
            int[] players = new int[0];
            int you = 0;
            int sindex;
            if (players[you].getBoats(sindex)!=null)
                players[you].getBoats(sindex).clearship();
            Object source = v.getSource();
            int i;
            outer:
            for (i=0;i<10;i++)
            {
                int j;
                for (j=0; j<10; j++)
                {
                    if (source==players[you].getBboard(i,j))
                    {
                        switch (sindex)
                        {
                            case 0: {
                                int w = 0;
                                if (w==0)
                                    w++;
                            }
                            break;
                            case 1: {
                                int a = 0;
                                if (a==0)
                                    a++;
                            }
                            break;
                            case 2: {
                                int s = 0;
                                if (s==0)
                                    s++;
                            }
                            break;
                            case 3: {
                                int t = 0;
                                if (t==0)
                                    t++;
                            }
                            break;
                            case 4: {
                                int e = 0;
                                if (e==0)
                                    e++;
                            }
                            break;
                        }
                        players[you].setBoats(sindex,new Ship(ships[sindex],dindex,length,i,j));
                        break outer;
                    }
                }
            }
            players[you].getBoats(sindex).placeship();
        }
    }


    //creates a panel that tells whose board is which
    private JPanel whoseBoard()
    {
        JPanel panel=new JPanel(new BorderLayout());
        int you = 0;
        FtpDirEntry[] players = new FtpDirEntry[0];
        panel.add(new JLabel(players[you].getUser()+"'s Board",SwingConstants.LEFT),BorderLayout.WEST);
        int enemy = 0;
        panel.add(new JLabel(players[enemy].getUser()+"'s Board",SwingConstants.RIGHT),BorderLayout.EAST);
        return panel;
    }

//Listener for exit choice on Game menu
private class ExitListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        int r= JOptionPane.showConfirmDialog(null,"Are you sure you would l"
                +"ike to exit Battleship?", "Exit?", JOptionPane.YES_NO_OPTION);
        if (r==0)
            System.exit(0);
    }
}

//listener for New Game submenu
private class GameListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        int q = JOptionPane.showConfirmDialog(null, "Are you sure you would l"
                + "ike to start a new game?", "New Game?", JOptionPane.YES_NO_OPTION);
        if (q == 0) {
            //resets variables
            b.removeAll();
            c.removeAll();
            d.removeAll();
            int you = 0;
            int enemy = 1;
            ready = 0;

            int[] players = new int[0];
            if (players[you].getTimer() != null)
                if (players[you].getTimer().isRunning())
                    players[you].getTimer().stop();
            if (players[enemy].getTimer() != null)
                if (players[enemy].getTimer().isRunning())
                    players[enemy].getTimer().stop();

            Object gametype = e.getSource();

            Object pvp = new Object();
            if (gametype == pvp) {
                String selectedValue = new String();
                if (!selectedValue.equals("no server")) {
                    String[] possibleValues = {"Local", "Online"};
                    selectedValue = (String) JOptionPane.showInputDialog(null,
                            "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null,
                            possibleValues, possibleValues[0]);
                }
                if (!players[you].getUser().equals("CPU1")) {
                    if (players[you].getUser().equals("Stupid")) {
                        int w = JOptionPane.showConfirmDialog(null, "Would you"
                                        + " like to try inputting your name again?", "",
                                JOptionPane.YES_NO_OPTION);
                        if (w == JOptionPane.YES_OPTION) {
                            user = JOptionPane.showInputDialog("Enter your name.");
                            int dummy = 0;
                            while (((user == null) || (user.equals(""))) && (dummy < 3)) {
                                user = JOptionPane.showInputDialog("You have to input something.");
                                if ((user != null) && (!user.equals("")))
                                    dummy = 4;
                                else
                                    dummy++;
                            }
                            if (dummy == 3) {
                                JOptionPane.showMessageDialog(null, "Still a"
                                                + "cting stupid.  Oh well, we'll run with it."
                                        , "", JOptionPane.INFORMATION_MESSAGE);
                                user = "Stupid";
                            } else
                                JOptionPane.showMessageDialog(null, "That wasn't"
                                                + " so hard now, was it?", "YEAH!",
                                        JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    players[you] = new Player(players[you].getUser());
                } else
                    players[you] = new Player(user);
                if (selectedValue.equals("Online")) {
                    players[enemy] = new Player("Unknown");
                    if (!isAutoSet()) {
                        b.add(setBoard(you), BorderLayout.CENTER);
                        deploy.setEnabled(false);
                        d.add(inputpanel, BorderLayout.NORTH);
                    } else {
                        b.add(autoBoard(you, enemy), BorderLayout.WEST);
                        c.add(autoBoard(enemy, you), BorderLayout.EAST);
                        ready = 1;
                    }
                } else {
                    //gets user to input name
                    if ((players[enemy].getUser().equals("Computer")) || (players[enemy].getUser().equals("CPU2")) || (players[enemy].getUser().equals("Unknown"))) {
                        user2 = JOptionPane.showInputDialog("Enter your name.");
                        while ((user2 == null) || (user2.equals(""))) {
                            user2 = JOptionPane.showInputDialog("You have to input something.");
                        }
                    } else
                        user2 = players[enemy].getUser();
                    players[enemy] = new Player(user2);
                    b.add(autoBoard(you, enemy), BorderLayout.WEST);
                    c.add(autoBoard(enemy, you), BorderLayout.EAST);
                    d.add(whoseBoard(), BorderLayout.NORTH);
                    whoGoesFirst();
                    ready = 1;
                }
                //ready=1;
            } else if (gametype == pvc)//Player vs Computer
            {
                if (!players[you].getUser().equals("CPU1")) {
                    if (players[you].getUser().equals("Stupid")) {
                        int w = JOptionPane.showConfirmDialog(null, "Would you"
                                        + " like to try inputting your name again?", "",
                                JOptionPane.YES_NO_OPTION);
                        if (w == JOptionPane.YES_OPTION) {
                            user = JOptionPane.showInputDialog("Enter your name.");
                            int dummy = 0;
                            while (((user == null) || (user.equals(""))) && (dummy < 3)) {
                                user = JOptionPane.showInputDialog("You have to input something.");
                                if ((user != null) && (!user.equals("")))
                                    dummy = 4;
                                else
                                    dummy++;
                            }
                            if (dummy == 3) {
                                JOptionPane.showMessageDialog(null, "Still a"
                                                + "cting stupid.  Oh well, we'll run with it."
                                        , "", JOptionPane.INFORMATION_MESSAGE);
                                user = "Stupid";
                            } else
                                JOptionPane.showMessageDialog(null, "That wasn't"
                                                + " so hard now, was it?", "YEAH!",
                                        JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    players[you] = new Player(players[you].getUser());
                } else
                    players[you] = new Player(user);
                players[enemy] = new Player("Computer");
                if (!isAutoSet()) {
                    b.add(setBoard(you), BorderLayout.CENTER);
                    deploy.setEnabled(false);
                    d.add(inputpanel, BorderLayout.NORTH);
                } else {
                    b.add(autoBoard(you, enemy), BorderLayout.WEST);
                    c.add(autoBoard(enemy, you), BorderLayout.EAST);
                    whoGoesFirst();
                }
            } else if (gametype == cvc)//Computer vs Computer
            {
                mbar.setText("Battleship Demo");
                mbar.setEditable(false);
                d.add(mbar, BorderLayout.NORTH);
                players[you] = new Player("CPU1");
                players[enemy] = new Player("CPU2");
                b.add(autoBoard(you, enemy), BorderLayout.WEST);
                c.add(autoBoard(enemy, you), BorderLayout.EAST);
                whoGoesFirst();
            }
            pack();
            repaint();
        }
    }

    private boolean isAutoSet() {
    }

    private Object autoBoard(int enemy, int you) {
    }

    private void whoGoesFirst() {
    }

    private void repaint() {
    }

    private void pack() {
    }
}}
