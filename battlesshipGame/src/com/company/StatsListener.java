package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

private class StatsListener implements ActionListener
{
    //
    public void setup()
    {
        stats=new JPanel();
        ok.addActionListener(new OkListener());
        statistics.setSize(300,300);
        statistics.setResizable(false);
        statistics.getContentPane().add(ok, BorderLayout.SOUTH);
        //statistics.setLocation(700,200);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (data==null)
            setup();
        else
            stats.removeAll();
        stats.setLayout(new GridLayout(6,3));
        data=new JLabel("");
        stats.add(data);
        data=new JLabel("Player 1",SwingConstants.CENTER);
        stats.add(data);
        data=new JLabel("Player 2",SwingConstants.CENTER);
        stats.add(data);
        data=new JLabel("Names");
        stats.add(data);
        if (you == 0)
        {
            data=new JLabel(players[you].getUser(),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel(players[enemy].getUser(),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel("Shots Taken");
            stats.add(data);
            data=new JLabel(Integer.toString(players[you].getShots()),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel(Integer.toString(players[enemy].getShots()),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel("Hits");
            stats.add(data);
            data=new JLabel(Integer.toString(players[you].getHits()),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel(Integer.toString(players[enemy].getHits()),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel("Shot Accuracy");
            stats.add(data);
            data=new JLabel(players[you].getAcc(),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel(players[enemy].getAcc(),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel("Ships Left");
            stats.add(data);
            data=new JLabel(Integer.toString(players[you].getShipsLeft()),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel(Integer.toString(players[enemy].getShipsLeft()),SwingConstants.CENTER);
            stats.add(data);
        }
        else
        {
            data=new JLabel(players[enemy].getUser(),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel(players[you].getUser(),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel("Shots Taken");
            stats.add(data);
            data=new JLabel(Integer.toString(players[enemy].getShots()),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel(Integer.toString(players[you].getShots()),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel("Hits");
            stats.add(data);
            data=new JLabel(Integer.toString(players[enemy].getHits()),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel(Integer.toString(players[you].getHits()),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel("Shot Accuracy");
            stats.add(data);
            data=new JLabel(players[enemy].getAcc(),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel(players[you].getAcc(),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel("Ships Left");
            stats.add(data);
            data=new JLabel(Integer.toString(players[enemy].getShipsLeft()),SwingConstants.CENTER);
            stats.add(data);
            data=new JLabel(Integer.toString(players[you].getShipsLeft()),SwingConstants.CENTER);
            stats.add(data);
        }
        statistics.getContentPane().add(stats);
        statistics.pack();
        statistics.setVisible(true);
    }
}
