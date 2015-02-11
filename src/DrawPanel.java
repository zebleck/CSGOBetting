package com.Bettingguru;

/*
	Displays data found on http://csgolounge.com in an organized and presentable way
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
	
	private ArrayList<VsPanel> vsPanels;
	
    public DrawPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(230, 230, 230));

        vsPanels = new ArrayList<VsPanel>();
        
        init();
    }

    private void init() {
    	GridBagConstraints c = new GridBagConstraints();
    	
	    		
    	try {
    		Document csglInfo = Jsoup.connect("http://csgolounge.com/").get();
	        Elements matches = csglInfo.select(".matchmain");


	        for (int i = 0; i < matches.size(); i++) {

                String t1Name = matches.get(i).select(".teamtext b").get(0).text() + " (" + matches.get(i).select(".teamtext i").get(0).text() + ")";
                String t2Name = matches.get(i).select(".teamtext b").get(1).text() + " (" + matches.get(i).select(".teamtext i").get(1).text() + ")";
                String time = matches.get(i).select(".whenm").first().ownText();
                String fileName = matches.get(i).select("a").first().attr("href");
                boolean isLive = false;
                if (matches.get(i).select(".whenm span").first().text().contains("LIVE")) {
                    isLive = true;
                }

                JPanel t1Panel = new JPanel();
                JLabel t1Label = new JLabel(t1Name, SwingConstants.CENTER);
                t1Label.setFont(new Font("Arial", Font.PLAIN, 20));
                t1Panel.setLayout(new BorderLayout());
                t1Panel.add(t1Label, BorderLayout.CENTER);

                JPanel t2Panel = new JPanel();
                JLabel t2Label = new JLabel(t2Name, SwingConstants.CENTER);
                t2Label.setFont(new Font("Arial", Font.PLAIN, 20));
                t2Panel.setLayout(new BorderLayout());
                t2Panel.add(t2Label, BorderLayout.CENTER);

                // epic pattern
                if (i % 2 == 0) {
                    t2Panel.setBackground(new Color(150, 150, 100));
                    t2Label.setForeground(new Color(10, 10, 10));
                    t1Panel.setBackground(new Color(10, 10, 10));
                    t1Label.setForeground(new Color(150, 150, 100));
                } else {
                    t2Panel.setBackground(new Color(10, 10, 10));
                    t2Label.setForeground(new Color(150, 150, 100));
                    t1Panel.setBackground(new Color(150, 150, 100));
                    t1Label.setForeground(new Color(10, 10, 10));
                }


                VsPanel vsPanel = new VsPanel(t1Name + "vs" + t2Name, "<html><u>VS</u></html>", i, fileName);

                if (time.contains("ago") && !isLive) {
                    vsPanel.setText("<html><u>CLOSED</u></html>");
                } else if (time.contains("ago") && isLive) {
                    vsPanel.setLabelForeground(new Color(50, 150, 50));
                    vsPanel.setText("<html><u>LIVE</u></html>");
                }
                vsPanels.add(vsPanel);

                JPanel timePanel = new JPanel();
                JLabel timeLabel = new JLabel(time, SwingConstants.CENTER);
                timePanel.setBackground(new Color(240, 100, 100));
                timeLabel.setForeground(new Color(10, 10, 10));
                timeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                timePanel.setLayout(new BorderLayout());
                timePanel.add(timeLabel, BorderLayout.CENTER);
                
                //adding everything with GridBagConstraints
                c.fill = GridBagConstraints.BOTH;
                c.weightx = 1;
                c.weighty = 1;
                c.ipady = 50;
                c.ipadx = 50;
                c.gridx = 0;
                c.gridy = i;
                add(t1Panel, c);

                c.gridx = 1;
                add(vsPanel, c);

                c.weightx = 1;
                c.gridx = 2;
                add(t2Panel, c);

                c.gridx = 3;
                c.weightx = 0;
                add(timePanel, c);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            JLabel errorLabel = new JLabel("Couldn't load matches !");
            errorLabel.setFont(new Font("Arial", Font.PLAIN, 30));
            c.gridx = 0;
            c.gridy = 0;
            add(errorLabel, c);
        }
    	//set default vsLabel listeners to direct to csgolounge match page
    	setLinks(0);
    }
    
    public void setLinks(int option) {
    	
    	//removes all listeners from the labels
        for(VsPanel panel : vsPanels) {
        	panel.setLink(option);
        }
    }
}