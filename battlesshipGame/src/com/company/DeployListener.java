package com.company;

import jdk.internal.jimage.ImageStrings;
import jdk.internal.org.objectweb.asm.tree.AbstractInsnNode;
import jdk.internal.org.objectweb.asm.tree.InsnList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

private class DeployListener implements ActionListener
{
    private Object input;

    public void actionPerformed(ActionEvent v)
    {
        int r= JOptionPane.showConfirmDialog(null,"Are you sure you would l"
                        +"ike to deploy your ships?", "Deploy Ships?",
                JOptionPane.YES_NO_OPTION);
        if (r==0)
        {
            int w = 0;
            int a = 0;
            int s = 0;
            int t = 0;
            int e = 0;
            InsnList d = null;
            d.remove((AbstractInsnNode) input);
            int[] players = new int[0];
            InsnList b = null;
            int you = 0;
            b.add(players[you].getMyBoard(), BorderLayout.WEST);
            int ready = 1;
            InsnList c = null;
            Object enemy = null;
            c.add(autoBoard(enemy,you),BorderLayout.EAST);
            d.add(new JPanel(),BorderLayout.CENTER);
            String selectedValue = null;
            if (!selectedValue.equals("Online"))
                whoGoesFirst();
            pack();
            repaint();
        }
    }

    private void repaint() {
    }

    private void pack() {
    }

    private void whoGoesFirst() {
    }
}