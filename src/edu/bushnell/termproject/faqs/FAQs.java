package edu.bushnell.termproject.faqs;


import java.awt.Component;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class FAQs {
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
