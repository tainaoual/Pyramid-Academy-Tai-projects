package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

private class ShipsListener implements ActionListener
{
    public void actionPerformed(ActionEvent v)
    {
        sindex=cshi.getSelectedIndex();
        if (players[you].getBoats(sindex)!=null)
            cdir.setSelectedIndex(players[you].getBoats(sindex).getDirect());
        switch (sindex)
        {
            case 0:         length=5;
                break;
            case 1:         length=4;
                break;
            case 2:         length=3;
                break;
            case 3:         length=3;
                break;
            case 4:         length=2;
                break;
        }
        if (players[you].getBoats(sindex) != null)
        {
            Ship boat=new Ship(ships[sindex],players[you].getBoats(sindex).getDirect()
                    ,length,players[you].getBoats(sindex).getX(),players[you].getBoats(sindex).getY());
            players[you].getBoats(sindex).clearship();
            players[you].setBoats(sindex,boat);
            players[you].getBoats(sindex).placeship();
        }
    }
}

//Listener for the Direction combo box
private class DirectListener implements ActionListener
{
    public void actionPerformed(ActionEvent v)
    {
        DefaultSingleSelectionModel cdir = new DefaultSingleSelectionModel();
        Object dindex = cdir.getSelectedIndex();
        int[] players = new int[0];
        int you;
        int sindex = 0;
        if (players[you].getBoats(sindex) != null)
        {
            int[] ships = new int[0];
            Ship boat=new Ship(ships[sindex],dindex,players[you].getBoats(sindex).getLength(),
                    players[you].getBoats(sindex).getX(),players[you].getBoats(sindex).getY());
            players[you].getBoats(sindex).clearship();
            players[you].setBoats(sindex,boat);
            players[you].getBoats(sindex).placeship();
        }
    }
}
