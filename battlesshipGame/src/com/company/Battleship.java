package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.util.Calendar;

public class Battleship extends JFrame
{
    private static JButton ok = new JButton("OK"),//closes stats menu
            done =new JButton("Done");//closes options menu
    private static JFrame statistics= new JFrame("Statistics"),//holds stats
            options=new JFrame("Options");//holds opts
    private static JLabel data,//used for stats menu
            title;//used for options menu
    private static JPanel stats=new JPanel(),//used for stats menu
            opts,//used for options menu
            inputpanel;//for manually inputting ships
    private static Container b,c,d;//board and input panel
    private JPanel input;//input bar
    private static JMenuItem m,pvp,pvc,cvc;//menu items
    private static String[] cletters = {" ","A","B","C","D","E","F","G","H","I","J"},
    //array of letters used for combo boxes
    cnumbers = {" ","1","2","3","4","5","6","7","8","9","10"},
    //array of numbers used for combo boxes
    ships = {"Carrier","Battleship","Submarine","Destroyer",
            "Patrol Boat"},//strings used for ship combo box
            direction = {"Horizontal","Vertical"},//directions
            level={"Normal", "Ridiculously Hard"},
            layout={"Manual","Automatic"},
            colors={"Cyan", "Green", "Yellow", "Magenta", "Pink", "Red",
                    "White"},
            first={"Player 1", "Player 2", "Random"};//used for options
    private JComboBox cshi = new JComboBox(ships),//ships
            cdir = new JComboBox(direction);//directions
    private static JComboBox aiLevel=new JComboBox(level),
            shipLayout=new JComboBox(layout),
            shipColor=new JComboBox(colors),
            playsFirst=new JComboBox(first);//used
    //for options menu
    private JTextField mbar = new JTextField();//message bar
    private static int enemy=1,
            i,j,//counters
            length=5,
            you=0,
            prevcolor=0,//index of previous color
            prevFirst=0,
            prevLayout=0,
            prevLevel=0,//tracks changes in corresponding comboboxes
            ready=0,
            sindex=0,//stores index of array
            dindex=0;//direction
    private static Player players[]=new Player[2];
    private static JButton deploy=new JButton("DEPLOY");
    private static int w=0,a=0,s=0,t=0,e=0;//counters to track the use of all ships
    private static String[][] shiphit=new String[10][10];
    private static String user,user2;
    private static Color[] color={Color.cyan,Color.green,Color.yellow,Color.magenta,
            Color.pink,     Color.red,      Color.white};
    private static Object selectedValue=" ",
            gametype;
   // private static BattleshipClient me;
    private static boolean gameover=false;

    public Battleship()
    {
        setTitle("Battleship");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(createMenuBar());
        setResizable(false);

        //gets user to input name
        user=JOptionPane.showInputDialog("Enter your name.");
        int dummy=0;
        while (((user==null)||(user.equals("")))&&(dummy<3))
        {
            user=JOptionPane.showInputDialog("You have to input something.");
            if ((user!=null)&&(!user.equals("")))
                dummy=4;
            else
                dummy++;
        }
        if (dummy==3)
        {
            JOptionPane.showMessageDialog(null,"Since you're having trouble inp"
                    +"utting your name, I'll just call you stupid.","",JOptionPane.INFORMATION_MESSAGE);
            user="Stupid";
        }
        players[you]=new Player (user);
        players[enemy]=new Player ("Computer");
        b=getContentPane();
        b.add(setBoard(you),BorderLayout.CENTER);
        c=getContentPane();
        d = getContentPane();
        inputpanel=shipinput();
        d.add(inputpanel,BorderLayout.NORTH);
        pack();
        setVisible(true);

    }

    public static boolean getGameOver()
    {
        return gameover;
    }

    public static void setGameOver(boolean b)
    {
        gameover=b;
    }

    //method to determine who plays first
    public void whoGoesFirst() throws IOException {
        int x=0;
        if (playsFirst.getSelectedIndex()!=2)
        {
            if (playsFirst.getSelectedIndex()!=you)
                flipYou();
            players[playsFirst.getSelectedIndex()].getTimer().start();
            x=playsFirst.getSelectedIndex();
        }
        else
        {
            int rand=(int)(Math.random()*2);
            JOptionPane.showMessageDialog(null,players[rand].getUser()+" will "
                    +"go first.","",JOptionPane.PLAIN_MESSAGE);
            if (rand!=you)
                flipYou();
            players[rand].getTimer().start();
            x=rand;
        }
        if
        ((!players[x].getUser().equals("Computer"))||(!players[x].getUser().equals("CPU1"))||(!players[x].getUser().equals("CPU2")))
            players[x].setMove(true);
    }

    //returns ship color, as selected by the user
    public static Color getColor()
    {
        return (color[shipColor.getSelectedIndex()]);
    }

    //asks if two players are playing on the same computer or over the web
    public static boolean isLocal()
    {
        if ((gametype==pvp)&&(selectedValue.equals("Local")))
            return true;
        else
            return false;
    }


    public static void flipYou()
    {
        if (you==1)
        {
            you=0;
            enemy=1;
        }
        else
        {
            you=1;
            enemy=0;
        }
    }

    //determines whether or not is shipLayout is set to automatic
    public static boolean isAutoSet()
    {
        if (shipLayout.getSelectedIndex()==0)
            return false;
        else
            return true;
    }


    //variable that determines whether or not a carrier has been placed
    public static int getW()
    {
        return w;
    }

    //variable that determines whether or not a battleship has been placed
    public static int getA()
    {
        return a;
    }

    //variable that determines whether or not a submarine has been placed
    public static int getS()
    {
        return s;
    }

    //variable that determines whether or not a destroyer has been placed
    public static int getT()
    {
        return t;
    }

    //variable that determines whether or not a patrol boat has been placed
    public static int getE()
    {
        return e;
    }

    public static int getReady()
    {
        return ready;
    }

    public static JFrame getStatistics()
    {
        return statistics;
    }

    public static void setData(JLabel x)
    {
        data=x;
    }

    public static JLabel getData()
    {
        return data;
    }

    public static JPanel getStats()
    {
        return stats;
    }

    public static void setDeploy(boolean k)
    {
        deploy.setEnabled(k);
    }

    public static Player getPlayers(int x)
    {
        return players[x];
    }

    public static String getDirection(int i)
    {
        return direction[i];
    }

    public static String getCletters(int i)
    {
        return cletters[i];
    }

    public static String getShips(int i)
    {
        return ships[i];
    }

    public static String getCnumbers(int i)
    {
        return cnumbers[i];
    }

    public static int getSIndex()
    {
        return sindex;
    }

    public static int getDIndex()
    {
        return dindex;
    }

    public static int getYou()
    {
        return you;
    }

    public static int getEnemy()
    {
        return enemy;
    }

    public static void setYou(int x)
    {
        you=x;
    }

    public static void setEnemy(int x)
    {
        enemy=x;
    }

    //creates Game menu and submenus
    public JMenuBar createMenuBar()
    {
        JMenu menu;//menu

        // create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // build the Game menu
        menu = new JMenu("Game");
        menuBar.add(menu);
        m = new JMenu("New Game");
        menu.add(m);

        //submenu of New Game
        GameListener stuff = new GameListener();
        pvp = new JMenuItem("Player vs. Player");
        pvp.addActionListener((ActionListener) stuff);
        m.add(pvp);
        pvc = new JMenuItem("Player vs. Computer");
        pvc.addActionListener((ActionListener) stuff);
        m.add(pvc);
        cvc = new JMenuItem("Computer vs. Computer");
        cvc.addActionListener((ActionListener) stuff);
        m.add(cvc);

        m = new JMenuItem("Rules");
        m.addActionListener(new RulesListener());
        menu.add(m);
        m = new JMenuItem("Statistics");
        m.addActionListener(new StatsListener());
        menu.add(m);
        m = new JMenuItem("Options");
        m.addActionListener(new OptionsListener());
        menu.add(m);
        m = new JMenuItem("Exit");
        m.addActionListener(new ExitListener());
        menu.add(m);
        return menuBar;
    }

    //creates panels that used to place ships
    public JPanel shipinput()
    {
        input= new JPanel();
        mbar.setText("Select a ship, its front position and direction.");
        mbar.setFont(new Font("Courier New", Font.BOLD, 14));
        mbar.setEditable(false);
        //input.add(mbar);
        cshi.setSelectedIndex(0);
        cshi.addActionListener(new ShipsListener());
        TitledBorder title;//used for titles around combo boxes
        title = BorderFactory.createTitledBorder("Ships");
        cshi.setBorder(title);
        input.add(cshi);
        cdir.setSelectedIndex(0);
        cdir.addActionListener(new DirectListener());
        input.add(cdir);
        title = BorderFactory.createTitledBorder("Direction");
        cdir.setBorder(title);
        deploy.setEnabled(false);
        deploy.addActionListener(new DeployListener());
        input.add(deploy);
        return input;
    }

    //creates board for manual ship placement
    public Component setBoard(int n)
    {
        players[n].setMyBoard(new JPanel(new GridLayout(11,11)));//panel to store board
        JTextField k;
        for (i=0;i<11;i++)
        {
            for (j=0;j<11;j++)
            {
                if ((j!=0)&&(i!=0))
                {
                    players[n].getBboard(i-1,j-1).addActionListener(new BoardListener());
                    players[n].getMyBoard().add(players[n].getBboard(i-1,j-1));
                }
                if (i==0)
                {
                    if (j!=0)
                    {
                        //used to display row of numbers
                        k= new JTextField(Battleship.getCnumbers(j));
                        k.setEditable(false);
                        k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT);
                    }
                    else
                    {
                        //used to display column of numbers
                        k= new JTextField();
                        k.setEditable(false);
                    }
                    players[n].getMyBoard().add(k);
                }
                else if (j==0)
                {
                    k= new JTextField(Battleship.getCletters(i));
                    k.setEditable(false);
                    k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT);
                    players[n].getMyBoard().add(k);
                }
            }
        }
        return players[n].getMyBoard();
    }

    //creates board and automatically places ship
    public Calendar autoBoard(int u, int t)
    {
        players[u].setGBoard(new JPanel(new GridLayout(11,11)));//panel to store board
        JTextField k;
        if (!players[u].getUser().equals("Unknown"))
            for (i=0;i<5;i++)
            {
                players[u].setGBoard(i,players[u].getGBoard(i).compinput(i,u));
            }
        for (i=0;i<11;i++)
        {
            for (j=0;j<11;j++)
            {
                if ((j!=0)&&(i!=0))
                {
                    if ((players[u].getUser().equals("Computer"))||(isLocal()))
                    {
                        players[u].getBboard(i-1,j-1).addActionListener(new AttackListener());
                    }
                    else if
                    ((players[t].getUser().equals("Computer"))||(players[t].getUser().equals("CPU1"))||(players[t].getUser().equals("CPU2"))||(players[t].getUser().equals("Unknown")))
                    {
                        if (players[u].getHitOrMiss(i-1,j-1))
                            players[u].setBboard(i-1,j-1,getColor());
                    }
                    else
                    {
                        players[u].getBboard(i-1,j-1).addActionListener(new InternetListener());
                    }
                    players[u].getGBoard().add(players[u].getBboard(i-1,j-1));
                }
                if (i==0)
                {
                    if (j!=0)
                    {
                        //used to display row of numbers
                        k= new JTextField(Battleship.getCnumbers(j));
                        k.setEditable(false);
                        k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT);
                    }
                    else
                    {
                        //used to display column of numbers
                        k= new JTextField();
                        k.setEditable(false);
                    }
                    players[u].getGBoard().add(k);
                }
                else if (j==0)
                {
                    k= new JTextField(Battleship.getCletters(i));
                    k.setEditable(false);
                    k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT);
                    players[u].getGBoard().add(k);
                }
            }
        }
        return players[u].getGBoard();
    }}

//Listener for combo boxes used to layout ships

