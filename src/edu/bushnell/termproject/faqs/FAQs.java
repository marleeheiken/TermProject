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
        JTextArea missionFAQ = createTextArea(
            "What is our mission?\n\n" +
            "Our mission is to provide innovative solutions that enhance user experience " +
            "and drive technological advancement. We are committed to pushing the boundaries " +
            "of technology while maintaining a focus on user-centric design and functionality."
        );
        panel.add(missionFAQ);

        // Support FAQ
        JTextArea supportFAQ = createTextArea(
            "How can I contact support?\n\n" +
            "You can reach our support team through multiple channels:\n" +
            "- Email: support@example.com\n" +
            "- Phone: 1-800-HELP-NOW\n" +
            "- Live Chat: Available on our website during business hours\n\n" +
            "Our support team is dedicated to providing prompt and helpful assistance."
        );
        panel.add(supportFAQ);

        // Payment FAQ
        JTextArea paymentFAQ = createTextArea(
            "What payment methods do you accept?\n\n" +
            "We accept a variety of payment methods:\n" +
            "- Major Credit Cards (Visa, MasterCard, American Express)\n" +
            "- PayPal\n" +
            "- Bank Transfers\n" +
            "- Apple Pay and Google Pay\n\n" +
            "Secure and flexible payment options for our customers."
        );
        panel.add(paymentFAQ);

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


