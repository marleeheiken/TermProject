package edu.bushnell.termproject.login;

import edu.bushnell.termproject.GUI;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class Login {

    public static JPanel MakeGUI(JPanel cardPanel) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.decode("#011E40")); // Bushnell Blue

        panel.add(Box.createRigidArea(new Dimension(0,25)));
        Box titleBox = Box.createVerticalBox();
        titleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleBox.setAlignmentY(Component.TOP_ALIGNMENT);
        titleBox.add(GUI.text("Login Information", 400, 30, 26, Color.WHITE, "center"));
        titleBox.add(Box.createRigidArea(new Dimension(0,50)));
        panel.add(titleBox);

        // create middle box for entries
        Box middleBox = Box.createHorizontalBox();
        middleBox.setMaximumSize(new Dimension(1000, 450));
        middleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        middleBox.setAlignmentY(Component.TOP_ALIGNMENT);
        Box entryBox = Box.createVerticalBox();
        entryBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        entryBox.setAlignmentY(Component.TOP_ALIGNMENT);

        // name fields
        Box nameBox = Box.createHorizontalBox();
        nameBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameBox.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel firstNameLabel = GUI.text("First", 200, 30, 20, Color.WHITE, "left");
        JLabel lastNameLabel  = GUI.text("Last",  200, 30, 20, Color.WHITE, "left");
        nameBox.add(Box.createRigidArea(new Dimension(220,0)));
        nameBox.add(firstNameLabel);
        nameBox.add(Box.createRigidArea(new Dimension(20,0)));
        nameBox.add(lastNameLabel);
        entryBox.add(nameBox);
        Box firstLastNameBox = Box.createHorizontalBox();
        firstLastNameBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        firstLastNameBox.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel nameLabel = GUI.text("Name:", 200, 30, 20, Color.WHITE, "left");
        firstLastNameBox.add(nameLabel);
        firstLastNameBox.add(Box.createRigidArea(new Dimension(20,0)));
        JTextField firstName = GUI.textField(15, 200, 30, 26);
        firstLastNameBox.add(firstName);
        firstLastNameBox.add(Box.createRigidArea(new Dimension(20,0)));
        JTextField lastName = GUI.textField(15, 200, 30, 26);
        firstLastNameBox.add(lastName);
        entryBox.add(firstLastNameBox);
        entryBox.add(Box.createRigidArea(new Dimension(0,20)));

        // create email number
        JLabel emailLabel = GUI.text("Enter your Bushnell Username:", 420, 30, 20, Color.WHITE, "left");
        JLabel instructionsLabel = GUI.text("(without @bushnell.edu)", 420, 22, 22, Color.WHITE, "left");
       
        // Create a vertical box for the phone number label and instructions
        Box emailLabelBox = Box.createVerticalBox();
        emailLabelBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        emailLabelBox.setAlignmentY(Component.TOP_ALIGNMENT);

        // Add the labels to the vertical box
        emailLabelBox.add(emailLabel);
        emailLabelBox.add(instructionsLabel);
        emailLabelBox.add(Box.createRigidArea(new Dimension(0, 15)));

        // Add the phoneLabelBox to the phoneBox (which is still horizontal for the input fields)
        Box emailBox = Box.createHorizontalBox();
        emailBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        emailBox.setAlignmentY(Component.TOP_ALIGNMENT);
        emailBox.add(emailLabelBox); // Add the vertical box with labels
        emailBox.add(Box.createRigidArea(new Dimension(20, 0))); // Space between label and input field

        // Add the text field for phone number
        JTextField email = GUI.textField(15, 200, 30, 26);
        emailBox.add(email);

        // Add emailBox to entryBox
        entryBox.add(Box.createRigidArea(new Dimension(0, 15)));
        entryBox.add(emailBox);
        entryBox.add(Box.createRigidArea(new Dimension(0, 20)));

        // create password
        Box password = Box.createHorizontalBox();
        password.setAlignmentX(Component.LEFT_ALIGNMENT);
        password.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel passwordLabel = GUI.text("Enter your Bushnell password:", 420, 33, 20, Color.WHITE, "left");
        password.add(passwordLabel);
        password.add(Box.createRigidArea(new Dimension(20,0)));
        JPasswordField passwordEntry = new JPasswordField(15);  // Changed to JPasswordField
        passwordEntry.setPreferredSize(new Dimension(200, 30));  // Set size similar to previous text field
        passwordEntry.setMaximumSize(new Dimension(200, 30));   // Ensure consistent sizing
        password.add(passwordEntry);
        entryBox.add(password);
        entryBox.add(Box.createRigidArea(new Dimension(0,20)));


        // create action buttons
        Box actionBox = Box.createHorizontalBox();
        actionBox.setMaximumSize(new Dimension(1000, 200));
        actionBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        actionBox.setAlignmentY(Component.TOP_ALIGNMENT);  
        JButton submitButton = GUI.button("Submit", 300, 50, 20);
        actionBox.add(submitButton);
        actionBox.add(Box.createRigidArea(new Dimension(50,0)));

        Box wrapperBox = Box.createVerticalBox();  // Change to VerticalBox for stacking
        entryBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        actionBox.setAlignmentX(Component.LEFT_ALIGNMENT);

        wrapperBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        wrapperBox.add(entryBox); 
        wrapperBox.add(Box.createRigidArea(new Dimension(0, 20))); // Add some spacing between entryBox and buttons
        wrapperBox.add(actionBox); 
        panel.add(wrapperBox);

        submitButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel,"Welcome");
            }
        });
        
        return panel;      
    }
}