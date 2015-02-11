package com.Bettingguru;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class VsPanel extends JPanel {
	
	private String context;
	private JLabel vsLabel;
	private int count;
	private String fileName;
	
	public VsPanel(String context, String text, int count, String fileName) {
		setLayout(new BorderLayout());
		setBackground(new Color(230, 230, 230));
		
		this.context = context;
		this.count = count;
		this.fileName = fileName;
		
		vsLabel = new JLabel(text, SwingConstants.CENTER); 
		vsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		vsLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		vsLabel.setForeground(new Color(239, 140, 22));
		
		add(vsLabel, BorderLayout.CENTER);
	}
	
	public void setLink(int option) {
		for(MouseListener l : vsLabel.getMouseListeners()) {
    		vsLabel.removeMouseListener(l);
    	}
		
		 //adds the listeners depending on the linkOption
        switch(option) {
        	// CSGO-Lounge
	        case 0:
	        	try {
		        		
		        	final String matchURL = "http://csgolounge.com/" +  fileName;
		        		
		        	vsLabel.addMouseListener(new MouseAdapter() {
	                    public void mouseClicked(MouseEvent e) {
	                        if (e.getClickCount() > 0) {
	                            Desktop desktop = Desktop.getDesktop();
	                            try {
	                                URI uri = new URI(matchURL);
	                                desktop.browse(uri);
	                            } catch (IOException ex) {
	                                ex.printStackTrace();
	                            } catch (URISyntaxException ex) {
	                                ex.printStackTrace();
	                            }
	                        }
	                    }
	                });
	                
	        		vsLabel.setForeground(new Color(239, 140, 22));
	        		vsLabel.setToolTipText(matchURL);
	        	
	        	} catch(Exception ex) { ex.printStackTrace(); }
	        	break;
	        	
	        	
	        	
	        // HLTV
	        case 1:
        		vsLabel.setForeground(new Color(21, 125, 240));
	        	break;
	        	
	        	
	        	
	        // Reddit
	        case 2:
        		vsLabel.setForeground(new Color(49, 234, 90));
	        	break;
	        	
	        	
	        	
        	default:
        		break;
        }
	}
	
	public void setText(String text) {
		vsLabel.setText(text);
	}
	
	public void setLabelForeground(Color fgColor) {
		vsLabel.setForeground(fgColor);
	}
}