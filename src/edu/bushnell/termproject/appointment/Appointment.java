package edu.bushnell.termproject.appointment;
 
import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
 
import edu.bushnell.termproject.GUI;
 
public class Appointment {
    public static JPanel MakeGUI() {
        // Create the main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
 
        // Set background color
        String bushnellBlueHashCode = "#011E40";
        Color bushnellBlue = Color.decode(bushnellBlueHashCode);
        panel.setBackground(bushnellBlue);
 
        // Add month label
        JLabel monthLabel = GUI.text("December", 720, 40, 24, Color.WHITE, "center");
        monthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(monthLabel);
 
        // Create the calendar grid
        JPanel calendarGrid = new JPanel(new GridLayout(6, 7));
        GUI.setDimension(calendarGrid, 720, 480);
        calendarGrid.setBackground(bushnellBlue);
 
        // Add day headers
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : daysOfWeek) {
            JLabel dayLabel = GUI.text(day, 100, 40, 16, Color.WHITE, "center");
            JPanel headerBox = new JPanel();
            headerBox.setBackground(bushnellBlue);
            headerBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            headerBox.add(dayLabel);
            calendarGrid.add(headerBox);
        }
 
        // Add day boxes
        int[] weekends = {1, 7, 8, 14, 15, 21, 22, 28, 29};
        int[] specialDays = {24, 25, 31};
        Map<Integer, JPanel> dayPanels = new HashMap<>();
 
        for (int i = 1; i <= 31; i++) {
            JPanel dayBox = new JPanel();
            dayBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            dayBox.setBackground(bushnellBlue);
 
            JLabel dayLabel = GUI.text(String.valueOf(i), 40, 40, 14, Color.WHITE, "center");
            dayBox.add(dayLabel);
            dayPanels.put(i, dayBox);
 
            if (contains(weekends, i) || contains(specialDays, i)) {
                dayBox.setBackground(Color.DARK_GRAY);
                dayLabel.setForeground(Color.WHITE);
            }
 
            dayBox.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    if (dayBox.getBackground().equals(Color.DARK_GRAY)) {
                        dayBox.setBackground(bushnellBlue);
                        dayLabel.setForeground(Color.WHITE);
                    } else if (SwingUtilities.isLeftMouseButton(e)) {
                        dayBox.setBackground(Color.GREEN);
                        dayLabel.setForeground(Color.BLACK);
                    } else if (SwingUtilities.isRightMouseButton(e)) {
                        dayBox.setBackground(Color.DARK_GRAY);
                        dayLabel.setForeground(Color.WHITE);
                    }
                }
            });
 
            calendarGrid.add(dayBox);
        }
 
        panel.add(calendarGrid);
 
        // Add key panel and toggle button
        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        keyPanel.setBackground(bushnellBlue);
 
        JLabel availableKey = GUI.text("Green - Available", 200, 40, 16, Color.GREEN, "center");
        JLabel unavailableKey = GUI.text("Dark - Unavailable", 200, 40, 16, Color.WHITE, "center");
        keyPanel.add(availableKey);
        keyPanel.add(Box.createHorizontalStrut(20));
        keyPanel.add(unavailableKey);
 
        //JButton toggleEditMode = GUI.button("Toggle Edit Mode", 200, 40, 16);
        //toggleEditMode.addActionListener(new java.awt.event.ActionListener() {
          //  private boolean editMode = false;
 
        //    @Override
          //  public void actionPerformed(java.awt.event.ActionEvent e) {
          //      editMode = !editMode;
          //      toggleEditMode.setText(editMode ? "Edit Mode: ON" : "Edit Mode: OFF");
         //   }
        //});
 
        //keyPanel.add(toggleEditMode);
        panel.add(keyPanel);
 
        panel.setVisible(true);
        return panel;
    }
 
    private static boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}
 