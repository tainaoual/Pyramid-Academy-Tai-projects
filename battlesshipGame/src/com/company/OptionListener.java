package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        if (opts==null)
            setup();
        else
            options.setVisible(true);
    }

    public void setup()
    {
        opts=new JPanel(new GridLayout(4,2));
        title=new JLabel("Computer AI");
        opts.add(title);
        aiLevel.setSelectedIndex(0);
        opts.add(aiLevel);
        title=new JLabel("Ship Layout");
        opts.add(title);
        shipLayout.setSelectedIndex(0);
        opts.add(shipLayout);
        title=new JLabel("Ship Color");
        opts.add(title);
        shipColor.addActionListener(new SColorListener());
        shipColor.setSelectedIndex(0);
        opts.add(shipColor);
        title=new JLabel("Who Plays First?");
        opts.add(title);
        playsFirst.setSelectedIndex(0);
        opts.add(playsFirst);
        options.getContentPane().add(opts,BorderLayout.CENTER);
        //options.setSize(600,800);
        options.setResizable(false);
        done.addActionListener(new DoneListener());
        options.getContentPane().add(done,BorderLayout.SOUTH);
        options.setLocation(200,200);
        options.pack();
        options.setVisible(true);
    }

    //Listener for the Colors combo box
    private class SColorListener implements ActionListener
    {
        public void actionPerformed(ActionEvent v)
        {
            for (i=0;i<10;i++)
                for (j=0;j<10;j++)
                {
                    if (players[you].getBboard(i,j).getBackground()==color[prevcolor])
                        players[you].setBboard(i,j,color[shipColor.getSelectedIndex()]);
                    if (players[enemy].getBboard(i,j).getBackground()
                            ==color[prevcolor])
                        players[enemy].setBboard(i,j,color[shipColor.getSelectedIndex()]);
                }
            prevcolor=shipColor.getSelectedIndex();
        }
    }}
