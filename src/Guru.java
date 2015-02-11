package com.Bettingguru;

import javax.swing.*;

public class Guru {
    public static void main(String[] args) {

        //Creates the window and displays it
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame window = new JFrame("CSGL - Matches");
                    window.setVisible(true);
                    window.setContentPane(new MainPanel());
                    window.pack();
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}