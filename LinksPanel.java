package com.Bettingguru;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LinksPanel extends JPanel {

	final String[] urls = {"http://csgolounge.com/", "http://hltv.org/", "http://reddit.com/r/csgobetting/"};
	JLabel[] linkLabels;
	
	public LinksPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBackground(new Color(82,98,113));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		linkLabels = new JLabel[3];
		linkLabels[0] = new JLabel("CSGO-Lounge");
		linkLabels[1] = new JLabel("HLTV");
		linkLabels[2] = new JLabel("Reddit");
		
		for(JLabel label : linkLabels) {
			label.setForeground(new Color(175, 175, 100));
			label.setFont(new Font("Calibri", Font.PLAIN, 15));
			label.setCursor(new Cursor(Cursor.HAND_CURSOR));
			add(label);
		}
		
		assignLinks();
	}
	
	private void assignLinks() {
		for(int i = 0; i < linkLabels.length; i++) {
			final String url = urls[i];
			
			linkLabels[i].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() > 0) {
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            URI uri = new URI(url);
                            desktop.browse(uri);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (URISyntaxException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
		}
	}
	
}
