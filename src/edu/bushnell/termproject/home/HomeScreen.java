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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.FlowLayout; 


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
        JButton loginButton = GUI.button("Login", 125, 20, 15);
        loginButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        JButton faqButton = GUI.button("FAQs", 125, 20, 15);
        faqButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        login.add(loginButton);
        login.add(Box.createRigidArea(new Dimension(50,0)));
        login.add(faqButton);
        login.add(Box.createRigidArea(new Dimension(0,20)));
    
        menuBox.add(loginButton);
        menuBox.add(faqButton);
        menuBox.add(Box.createRigidArea(new Dimension(0,20)));


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
        titleBox.add(GUI.text("BUSHNELL COUNSELING CENTER", 300, 30, 15, Color.WHITE, "left"));
        titleBox.add(Box.createRigidArea(new Dimension(0,10)));
        titleBox.add(GUI.text("Located at: Siefke Hall ", 300, 30, 15, Color.WHITE, "left"));
        titleBox.add(Box.createRigidArea(new Dimension(0,50)));
        menuBox.add(titleBox);

        // Create buttons for Appointments, Client Information, and Online Advice
        Box buttons = Box.createVerticalBox();
        buttons.setAlignmentX(Component.LEFT_ALIGNMENT);
        JButton appointmentButton = GUI.button("Appointment", 300, 30, 20);
        JButton clientInformationButton = GUI.button("Client Information", 300, 30, 20);
        JButton onlineAdviceButton = GUI.button("Online Advice", 300, 30, 20);
        buttons.add(appointmentButton);
        buttons.add(Box.createRigidArea(new Dimension(0,20)));
        buttons.add(clientInformationButton);
        buttons.add(Box.createRigidArea(new Dimension(0,20)));
        buttons.add(onlineAdviceButton);
        
        menuBox.add(buttons);

        // create panels for each sub-menu
        JPanel loginPanel             = Login.MakeGUI();
        JPanel faqPanel               = FAQs.MakeGUI();
        JPanel appointmentPanel       = Appointment.MakeGUI();
        JPanel clientInformationPanel = ClientInformation.MakeGUI();
        JPanel onlineAdvicePanel      = OnlineAdvice.MakeGUI();

        // create a card panel (only one panel visible at a time)
        JPanel cardPanel = new JPanel(new CardLayout());
        cardPanel.add(loginPanel, "login");
        cardPanel.add(faqPanel, "FAQs");
        cardPanel.add(appointmentPanel,"appointment");
        cardPanel.add(clientInformationPanel,"clientInformation");
        cardPanel.add(onlineAdvicePanel,"onlineAdvice");
        subMenuBox.add(cardPanel);

        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel,"login");
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
                cardLayout.show(cardPanel,"login");
                //showButtons(false);
            }
        });

        faqButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel,"faq");
                //showButtons(false);
            }
        });

        mainPanel.setVisible(true);   
        return mainPanel;    
    }
}