package edu.bushnell.termproject.welcome;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;


public class Welcome {
    public static JPanel MakeGUI() {
        // create panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // set background color
        String bushnellBlueHashCode = "#011E40";
        Color bushnellBlue = Color.decode(bushnellBlueHashCode);
        panel.setBackground(bushnellBlue); 

        ImageIcon welcomeImageIcon = new ImageIcon(Welcome.class.getResource("/resources/welcomeImage.jpeg"));
        Image scaledWelcomeImage = welcomeImageIcon.getImage().getScaledInstance(800, -1, Image.SCALE_SMOOTH); // Adjust width as needed
        JLabel welcomeImageLabel = new JLabel(new ImageIcon(scaledWelcomeImage));
        welcomeImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        return panel;   
    }
}