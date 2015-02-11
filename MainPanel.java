package com.Bettingguru;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
	
	/*
		Class only contains the drawPanel and displays it for now
	*/

    public static final int WIDTH = 800;
    public static final int HEIGHT = 595;

    private DrawPanel drawPanel;
    private JScrollPane drawScroll;
    private MenuPanel menuPanel;

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
        
        init();
    }
    
    private void init() {
    	menuPanel.optionList.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String cbInput = (String) menuPanel.optionList.getSelectedItem();
        		
        		switch(cbInput) {
        			case "CSGO-Lounge":
        				drawPanel.setLinks(0);
	        			break;
	        		case "HLTV":
	        			drawPanel.setLinks(1);
	        			break;
	        		case "Reddit":
	        			drawPanel.setLinks(2);
	        			break;
        			default:
        				break;
        		}
        	}
        });
    }
}