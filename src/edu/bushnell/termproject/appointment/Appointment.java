package edu.bushnell.termproject.appointment;

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

import edu.bushnell.termproject.GUI;

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

        // create title
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        Box titleBox = Box.createVerticalBox();
        titleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleBox.setAlignmentY(Component.TOP_ALIGNMENT);
        titleBox.add(GUI.text("Schedule an Appointment", 400, 30, 26, Color.WHITE, "center"));
        titleBox.add(Box.createRigidArea(new Dimension(0,30)));
        panel.add(titleBox);

        // create days of week header
        Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
        JPanel calendarTitlePanel = new JPanel();
        calendarTitlePanel.setBackground(Color.GRAY); 
        calendarTitlePanel.setLayout(new GridLayout(1, 7));
        calendarTitlePanel.setMaximumSize(new Dimension(800, 50));
        calendarTitlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] daysOfWeek = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        for (int i=0; i<7; i++) {
            JLabel label = new JLabel(daysOfWeek[i]);
            label.setFont(new Font("Sans-Serif", Font.BOLD, 20));
            label.setPreferredSize(new Dimension(115,50));
            label.setHorizontalAlignment(SwingConstants.CENTER); 
            label.setForeground(Color.BLACK);
            label.setBorder(border);
            calendarTitlePanel.add(label);
        }
        panel.add(calendarTitlePanel);

        // create days of December buttons
        JPanel decemberPanel = new JPanel();
        decemberPanel.setBackground(bushnellBlue);
        decemberPanel.setLayout(new GridLayout(5, 7));
        decemberPanel.setMaximumSize(new Dimension(800, 500));
        decemberPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // specify which days are closed
        Boolean[] closed = {true, false, false, false, false, false, true,
                            true, false, false, false, false, false, true,
                            true, false, false, false, false, false, true,
                            true, false, true,  true,  false, false, true,
                            true, false, true};
        Color availableColor = Color.decode("#d2d916");  // yellow
        Color filledColor    = Color.decode("#999797");  // light gray
        Color closedColor    = Color.decode("#424242");  // dark gray

        // keep track if a day is available or filled
        // start out with all days available
        // eventually load from a  file
        Boolean[] available = new Boolean[31];
        Arrays.fill(available, true);

        // create an array of buttons
        final JButton[] buttons = new JButton[31];

        for (int i=0; i<31; i++) {
            // create a box for the day in December, colored based on availability
            Box dayBox = Box.createHorizontalBox();
            dayBox.setPreferredSize(new Dimension(115,100));
            dayBox.setMinimumSize(new Dimension(115,100));
            if (closed[i]) {
                dayBox.setBackground(closedColor);
            } else {
                if (available[i]) {
                    dayBox.setBackground(availableColor);
                } else {
                    dayBox.setBackground(filledColor);
                }
            }
            dayBox.setOpaque(true);
            dayBox.setBorder(border);

            // create a button labeled with the day in december
            buttons[i] = new JButton(String.valueOf(i+1));
            buttons[i].setFont(new Font("Sans-Serif", Font.BOLD, 20));
            buttons[i].setPreferredSize(new Dimension(115,100));
            buttons[i].setHorizontalAlignment(SwingConstants.CENTER);
            buttons[i].setForeground(Color.WHITE); 
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);

            // create a listener for the button that toggles its state
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // find which button was pressed and then change state available/filled
                    JButton clickedButton = (JButton) e.getSource();
                    for (int j = 0; j < buttons.length; j++) {
                        if (buttons[j] == clickedButton) {
                            // change available/filled state of this day
                            if (closed[j]) {
                                // do nothing - we're closed
                            } else {
                                if (available[j]) {
                                    available[j] = false; // set to filled
                                    dayBox.setBackground(filledColor);
                                } else {
                                    available[j] = true; // set to available
                                    dayBox.setBackground(availableColor);
                                }
                            }     
                            break;
                        }
                    }               
                }
            });
            dayBox.add(buttons[i]);
            decemberPanel.add(dayBox);
        }
        panel.add(decemberPanel);
        panel.add(Box.createRigidArea(new Dimension(0,20)));

        // create legend at the bottom
        Box legendBox = Box.createHorizontalBox();
        legendBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        legendBox.setAlignmentY(Component.TOP_ALIGNMENT);
        legendBox.setPreferredSize(new Dimension(600,50));
        legendBox.setMinimumSize(new Dimension(600,50));
        legendBox.setMaximumSize(new Dimension(600,50));
        JLabel label1 = new JLabel("Available");
        label1.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        label1.setPreferredSize(new Dimension(150,50));
        label1.setMinimumSize(new Dimension(150,50));
        label1.setMaximumSize(new Dimension(150,50));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(Color.WHITE); 
        label1.setBackground(availableColor);
        label1.setBorder(border);
        label1.setOpaque(true);
        legendBox.add(label1);
        legendBox.add(Box.createRigidArea(new Dimension(20,0)));
        JLabel label2 = new JLabel("Filled");
        label2.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        label2.setPreferredSize(new Dimension(150,50));
        label2.setMinimumSize(new Dimension(150,50));
        label2.setMaximumSize(new Dimension(150,50));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setForeground(Color.WHITE); 
        label2.setBackground(filledColor);
        label2.setBorder(border);
        label2.setOpaque(true);
        legendBox.add(label2);
        legendBox.add(Box.createRigidArea(new Dimension(20,0)));
        JLabel label3 = new JLabel("Closed");
        label3.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        label3.setPreferredSize(new Dimension(150,50));
        label3.setMinimumSize(new Dimension(150,50));
        label3.setMaximumSize(new Dimension(150,50));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setForeground(Color.WHITE); 
        label3.setBackground(closedColor);
        label3.setBorder(border);
        label3.setOpaque(true);
        legendBox.add(label3);
        panel.add(legendBox);

        panel.setVisible(true);         
        return panel;       
    }
}
 