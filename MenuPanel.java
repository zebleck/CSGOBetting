package com.Bettingguru;

import javax.swing.*;

import java.awt.*;

public class MenuPanel extends JPanel {

	private JLabel logoLabel;

	private final  String[] matchOptions = {"CSGO-Lounge", "HLTV", "Reddit"};
	private JLabel optionLabel;
	public JComboBox<String> optionList;
	private LinksPanel linksPanel;
	
    public MenuPanel() {
        setLayout(new FlowLayout(FlowLayout.LEADING));
        setBackground(new Color(122,138,153));

        JPanel linksPanel = new LinksPanel();
        optionLabel = new JLabel("Choose, which site you want information from:");
        optionList = new JComboBox<String>(matchOptions);

        add(linksPanel);
        add(optionLabel);
        add(optionList);
    }
}
