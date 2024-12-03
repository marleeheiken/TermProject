package edu.bushnell.termproject.home;

import edu.bushnell.termproject.appointment.Appointment;
import edu.bushnell.termproject.clientinfo.ClientInformation;
import edu.bushnell.termproject.onlineadvice.OnlineAdvice;
import edu.bushnell.termproject.login.Login;
import edu.bushnell.termproject.faqs.FAQs;
import edu.bushnell.termproject.welcome.Welcome;
import edu.bushnell.termproject.GUI;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;

class GetImage {
    public JLabel getImage(String filename) {
        return new JLabel(new ImageIcon(getClass().getResource("/resources/"+filename)));
    }
}

public class HomeScreen {

    // JButton appointmentButton;
    // JButton clientInformationButton;
    // JButton onlineAdviceButton;
    
    // private void showButtons(boolean visible) {
    //     appointmentButton.setVisible(visible);
    //     clientInformationButton.setVisible(visible);
    //     onlineAdviceButton.setVisible(visible);
    // }

    public JPanel MakeGUI() {

        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);

        // Create a main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS)); // Horizontal alignment
        mainPanel.setPreferredSize(new Dimension(1400, 800));
        mainPanel.setMaximumSize(new Dimension(1400, 800));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.setAlignmentY(Component.TOP_ALIGNMENT);

        String bushnellBlueHashCode = "#011E40";  // Set panel to a background color based on a RGB hashcode
        Color bushnellBlue = Color.decode(bushnellBlueHashCode);
        mainPanel.setBackground(bushnellBlue);

        Box homeBox = Box.createHorizontalBox();
        homeBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeBox.setAlignmentY(Component.TOP_ALIGNMENT);
        Box menuBox = Box.createVerticalBox();
        menuBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        menuBox.setAlignmentY(Component.TOP_ALIGNMENT);

        Box subMenuBox = Box.createHorizontalBox();
        subMenuBox.setPreferredSize(new Dimension(1060, 720));
        subMenuBox.setMaximumSize(new Dimension(1060, 720));
        subMenuBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        subMenuBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        subMenuBox.setAlignmentY(Component.TOP_ALIGNMENT);
        homeBox.add(Box.createRigidArea(new Dimension(20,0)));
        homeBox.add(menuBox);
        homeBox.add(Box.createRigidArea(new Dimension(20,0)));
        homeBox.add(subMenuBox);
        homeBox.add(Box.createRigidArea(new Dimension(20,0)));
        
        
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(homeBox);


        Box login = Box.createHorizontalBox();
        login.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JButton loginButton = GUI.button("Login", 110, 27, 15);
        loginButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));  // Set a square border
        loginButton.setForeground(Color.WHITE);  // Set text color to white
        JButton faqButton = GUI.button("FAQs", 110, 27, 15);
        faqButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        faqButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));  // Set a square border
        faqButton.setForeground(Color.WHITE);  // Set text color to white
       
        login.add(Box.createRigidArea(new Dimension(70,40)));
        login.add(loginButton);
        login.add(Box.createRigidArea(new Dimension(10,0)));
        login.add(faqButton);
        login.add(Box.createRigidArea(new Dimension(0,20)));
    
        // menuBox.add(loginButton);
        // menuBox.add(faqButton);
        // menuBox.add(Box.createRigidArea(new Dimension(0,20)));

        menuBox.add(login);
        menuBox.add(Box.createRigidArea(new Dimension(0, 20))); // Space below the buttons

        // Add the Bushnell logo to the left side
        ImageIcon bushnellLogo = new ImageIcon(getClass().getResource("/resources/bushnellLight.png"));
        Image scaledLogo = bushnellLogo.getImage().getScaledInstance(300, -1, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));
        
        logoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        menuBox.add(Box.createRigidArea(new Dimension(0,10)));
        menuBox.add(logoLabel);
        menuBox.add(Box.createRigidArea(new Dimension(0,50)));
        
        Box titleBox = Box.createVerticalBox();
        titleBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        titleBox.add(GUI.text("COUNSELING CENTER", 300, 30, 26, Color.WHITE, "left"));
        titleBox.add(Box.createRigidArea(new Dimension(0,0)));
        titleBox.add(GUI.text("755 East 11th Avenue, Eugene, OR 97401 ", 300, 30, 13, Color.WHITE, "left"));
        titleBox.add(Box.createRigidArea(new Dimension(0,50)));
        menuBox.add(titleBox);

        // Create buttons for Appointments, Client Information, and Online Advice
        Box buttons = Box.createVerticalBox();
        buttons.setAlignmentX(Component.LEFT_ALIGNMENT);
        JButton appointmentButton = GUI.button("Appointment", 300, 50, 20);
        appointmentButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));  // Set a square border
        appointmentButton.setForeground(Color.WHITE);  // Set text color to white

        JButton clientInformationButton = GUI.button("Client Information", 300, 50, 20);
        clientInformationButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));  // Set a square border
        clientInformationButton.setForeground(Color.WHITE);  // Set text color to white

        JButton onlineAdviceButton = GUI.button("Online Advice", 300, 50, 20);
        onlineAdviceButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));  // Set a square border
        onlineAdviceButton.setForeground(Color.WHITE);  // Set text color to white

        buttons.add(appointmentButton);
        buttons.add(Box.createRigidArea(new Dimension(0,20)));
        buttons.add(clientInformationButton);
        buttons.add(Box.createRigidArea(new Dimension(0,20)));
        buttons.add(onlineAdviceButton);
        
        menuBox.add(buttons);

        // create panels for each sub-menu
        JPanel faqPanel               = FAQs.MakeGUI();
        JPanel appointmentPanel       = Appointment.MakeGUI();
        JPanel clientInformationPanel = ClientInformation.MakeGUI();
        JPanel onlineAdvicePanel      = OnlineAdvice.MakeGUI();
        JPanel welcomePanel           = Welcome.MakeGUI();

        
        // create a card panel (only one panel visible at a time)
        JPanel cardPanel = new JPanel(new CardLayout());
        JPanel loginPanel             = Login.MakeGUI(cardPanel);

        cardPanel.add(faqPanel, "FAQs");
        cardPanel.add(appointmentPanel,"appointment");
        cardPanel.add(clientInformationPanel,"clientInformation");
        cardPanel.add(onlineAdvicePanel,"onlineAdvice");
        cardPanel.add(welcomePanel,"Welcome");
        cardPanel.add(loginPanel,"Login");


        subMenuBox.add(cardPanel);

        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel,"Login");

        //showButtons(false);


        // button listeners
        appointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel,"appointment");
                //showButtons(true);

            }
        });

        clientInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel,"clientInformation");
               // showButtons(true);

            }
        });

        onlineAdviceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel,"onlineAdvice");
                //showButtons(true);

            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel,"Login");
                //showButtons(false);
            }
        });

        faqButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel,"FAQs");
                //showButtons(false);
            }
        });

        mainPanel.setVisible(true);   
        return mainPanel;    
    }
}