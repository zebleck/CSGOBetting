package com.BettingGuru;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
	
	/*
		Class only contains the drawPanel and displays it for now
	*/

    public static final int WIDTH = 800;
    public static final int HEIGHT = 595;

    DrawPanel drawPanel;
    JScrollPane drawScroll;
    MenuPanel menuPanel;

    public MainPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());

        menuPanel = new MenuPanel();

        drawPanel = new DrawPanel();
        drawScroll = new JScrollPane(drawPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        drawScroll.getVerticalScrollBar().setUnitIncrement(12);

        add(drawScroll, BorderLayout.CENTER);
        add(menuPanel, BorderLayout.NORTH);
    }
}