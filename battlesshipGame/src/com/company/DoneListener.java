package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

private class DoneListener implements ActionListener {
    public void actionPerformed(ActionEvent e)
    {
        if ((shipLayout.getSelectedIndex()!=prevLayout)||
                (aiLevel.getSelectedIndex()!=prevLevel)||
                (playsFirst.getSelectedIndex()!=prevFirst))
        {
            JOptionPane.showMessageDialog(null,"Changes will take"+
                            " place at the start of a new game.",""
                    ,JOptionPane.PLAIN_MESSAGE);
            if (shipLayout.getSelectedIndex()!=prevLayout)
                prevLayout=shipLayout.getSelectedIndex();
            if (playsFirst.getSelectedIndex()!=prevFirst)
                prevFirst=playsFirst.getSelectedIndex();
            if (aiLevel.getSelectedIndex()!=prevLevel)
                prevLevel=aiLevel.getSelectedIndex();
        }
        options.dispose();
    }
}

