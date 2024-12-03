package edu.bushnell.termproject.faqs;

import edu.bushnell.termproject.GUI;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

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
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        
        JLabel titleLabel = new JLabel("FAQs", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0,40)));

        // Mission FAQ
        JTextArea costFAQ = createTextArea(
            "How much does a session cost?\n\n" +
            "We are happy to provide service free of charge for all Bushnell students, staff, and faculty, " +
            " and University of Oregon students. We also serve the general Eugene and greater" +
            " Lane County area with a rate of just $10 dollars per session" 
        );
        panel.add(costFAQ);

        // Support FAQ
        JTextArea receiveFAQ = createTextArea(
            "Can I receive counseling at the counseling center even if I am not Christian?\n\n" +
            "Bushnell University counselors welcome people of any belief system and do" +
            " not press any particular spiritual philosophy\n" 
        );
        panel.add(receiveFAQ);

        // Who provides counseling FAQ
        JTextArea whoFAQ = createTextArea(
            "Who provides the counseling?\n\n" +
            "The Bushnell University counseling center is a teaching facility" +
            "where graduate students earning a master’s degree in counseling" +
            "provide services under the supervision of experienced faculty members." 
        );
        panel.add(whoFAQ);

        JTextArea whoQualifiesFAQ = createTextArea(
            "Who can receive counseling services?\n\n" +
            "Adults (age 18+) in the community." 
        );
        panel.add(whoQualifiesFAQ);


        return panel;
    }

    private static JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea(text);
        textArea.setEditable(false);
        textArea.setBackground(Color.decode("#011E40"));
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMaximumSize(new Dimension(500, 300));
        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        return textArea;
    }
}


