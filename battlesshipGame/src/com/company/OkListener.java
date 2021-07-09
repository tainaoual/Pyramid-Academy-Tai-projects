package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

private class OkListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        statistics.dispose();
    }
}
