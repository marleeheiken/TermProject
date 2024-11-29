package edu.bushnell.termproject.appointment;

import edu.bushnell.termproject.GUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Appointment {
    public static JPanel MakeGUI() {
        // create panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // set background color
        String bushnellBlueHashCode = "#011E40";
        Color bushnellBlue = Color.decode(bushnellBlueHashCode);
        panel.setBackground(bushnellBlue); 
    
        return panel;       
    }
}
