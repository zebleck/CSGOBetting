package com.BettingGuru;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class MenuPanel extends JPanel {

    JLabel logoLabel;

    String[] matchOptions = {"CSGOLounge", "HLTV", "Reddit"};
    JLabel optionLabel;
    JComboBox optionList;

    public MenuPanel() {
        setLayout(new FlowLayout(FlowLayout.LEADING));
        setBackground(new Color(122,138,153));

        initLogo();

        optionLabel = new JLabel("Choose, which site you want information from:");
        optionList = new JComboBox(matchOptions);

        add(optionLabel);
        add(optionList);
    }

    private void initLogo() {
        Image image = null;
        try {
            URL url = new URL("http://cdn.csgolounge.com/img/logo.png");
            image = ImageIO.read(url);
        } catch (Exception ex) { ex.printStackTrace(); }

        logoLabel = new JLabel(new ImageIcon(image));
        logoLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        logoLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() > 0) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        URI uri = new URI("http://csgolounge.com/");
                        desktop.browse(uri);
                    } catch(IOException ex) {
                        ex.printStackTrace();
                    } catch(URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        add(logoLabel);
    }
}
