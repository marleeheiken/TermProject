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

        // Title Box (kept as is)
        Box titleBox = Box.createVerticalBox();
        titleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleBox.setAlignmentY(Component.TOP_ALIGNMENT);
        titleBox.add(GUI.text("Login Information", 400, 30, 26, Color.WHITE, "center"));
        titleBox.add(Box.createRigidArea(new Dimension(0,75)));
        panel.add(titleBox);

        // Create middle box for entries (aligned center)
        Box middleBox = Box.createHorizontalBox();
        middleBox.setMaximumSize(new Dimension(1000, 450));
        middleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        middleBox.setAlignmentY(Component.TOP_ALIGNMENT);
        
        Box entryBox = Box.createVerticalBox();
        entryBox.setAlignmentX(Component.CENTER_ALIGNMENT);  // Align entry box to the center
        entryBox.setAlignmentY(Component.TOP_ALIGNMENT);

        // Name fields (centered inside entryBox)
        Box nameBox = Box.createHorizontalBox();
        nameBox.setAlignmentX(Component.CENTER_ALIGNMENT);  // Change to center alignment
        nameBox.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel firstNameLabel = GUI.text("First", 200, 30, 20, Color.WHITE, "left");
        JLabel lastNameLabel  = GUI.text("Last",  200, 30, 20, Color.WHITE, "left");
        nameBox.add(Box.createRigidArea(new Dimension(220,0)));
        nameBox.add(firstNameLabel);
        nameBox.add(Box.createRigidArea(new Dimension(20,0)));
        nameBox.add(lastNameLabel);
        entryBox.add(nameBox);

        // First and last name entry fields (centered inside entryBox)
        Box firstLastNameBox = Box.createHorizontalBox();
        firstLastNameBox.setAlignmentX(Component.CENTER_ALIGNMENT);  // Align to the center
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

        // Email fields
        JLabel emailLabel = GUI.text("Enter your Bushnell Username:", 420, 30, 20, Color.WHITE, "left");
        JLabel instructionsLabel = GUI.text("(without @bushnell.edu)", 420, 22, 22, Color.WHITE, "left");
        Box emailLabelBox = Box.createVerticalBox();
        emailLabelBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        emailLabelBox.setAlignmentY(Component.TOP_ALIGNMENT);
        emailLabelBox.add(emailLabel);
        emailLabelBox.add(instructionsLabel);
        emailLabelBox.add(Box.createRigidArea(new Dimension(0, 15)));

        Box emailBox = Box.createHorizontalBox();
        emailBox.setAlignmentX(Component.CENTER_ALIGNMENT);  // Align to the center
        emailBox.setAlignmentY(Component.TOP_ALIGNMENT);
        emailBox.add(emailLabelBox);
        emailBox.add(Box.createRigidArea(new Dimension(20, 0)));

        JTextField email = GUI.textField(15, 200, 30, 26);
        emailBox.add(email);
        entryBox.add(Box.createRigidArea(new Dimension(0, 15)));
        entryBox.add(emailBox);
        entryBox.add(Box.createRigidArea(new Dimension(0, 20)));

        // Password fields
        Box password = Box.createHorizontalBox();
        password.setAlignmentX(Component.CENTER_ALIGNMENT);  // Align to the center
        password.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel passwordLabel = GUI.text("Enter your Bushnell password:", 420, 33, 20, Color.WHITE, "left");
        password.add(passwordLabel);
        password.add(Box.createRigidArea(new Dimension(20,0)));
        JPasswordField passwordEntry = new JPasswordField(15);
        passwordEntry.setPreferredSize(new Dimension(200, 30));
        passwordEntry.setMaximumSize(new Dimension(200, 30));
        password.add(passwordEntry);
        entryBox.add(password);
        entryBox.add(Box.createRigidArea(new Dimension(0,20)));

        // Create action buttons
        Box actionBox = Box.createHorizontalBox();
        actionBox.setMaximumSize(new Dimension(1000, 200));
        actionBox.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center align buttons
        actionBox.setAlignmentY(Component.TOP_ALIGNMENT);
        actionBox.add(Box.createRigidArea(new Dimension(177, 0)));  // Adds a 100px space before the button
        JButton submitButton = GUI.button("Submit", 300, 50, 20);
        submitButton.add(Box.createRigidArea(new Dimension(100,0)));
        actionBox.add(submitButton);
        actionBox.add(Box.createRigidArea(new Dimension(50,0)));

        // Wrapper box for entry and action boxes (centered)
        Box wrapperBox = Box.createVerticalBox();
        wrapperBox.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center-align the whole wrapper box
        wrapperBox.add(entryBox);
        wrapperBox.add(Box.createRigidArea(new Dimension(0, 20)));
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
