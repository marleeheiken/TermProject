package edu.bushnell.termproject.onlineadvice;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

import edu.bushnell.termproject.GUI;

public class OnlineAdvice {
    public static JPanel MakeGUI() {
        // Create a JPanel using BoxLayout and set its size
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(1060, 720));
        panel.setMaximumSize(new Dimension(1060, 720));
        // panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // panel.setAlignmentY(Component.TOP_ALIGNMENT);

        // Set panel to a background color based on a RGB hashcode
        String bushnellBlueHashCode = "#011E40";
        Color bushnellBlue = Color.decode(bushnellBlueHashCode);
        panel.setBackground(bushnellBlue);

        // Create a Box for the Title
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        Box titleBox = Box.createVerticalBox();
        titleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleBox.setAlignmentY(Component.TOP_ALIGNMENT);
        titleBox.add(GUI.text("Online Advice", 400, 30, 32, Color.WHITE, "center"));
        // titleBox.add(Box.createRigidArea(new Dimension(0,50)));
        panel.add(titleBox);

        // create advice type combo box
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        Box adviceCategoryBox = Box.createHorizontalBox();
        adviceCategoryBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        adviceCategoryBox.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel adviceCategoryLabel = GUI.text("What do you need help with?", 10, 30, 20, Color.WHITE, "left");
        adviceCategoryLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        GUI.setDimension(adviceCategoryLabel, 350,30);
        adviceCategoryBox.add(adviceCategoryLabel);
        // adviceCategoryBox.add(Box.createRigidArea(new Dimension(20,0)));
        String[] adviceCategories = {"Anger", "Stress", "Relationship", "Depression"};
        JComboBox<String> adviceCategory = new JComboBox<>(adviceCategories); 
        GUI.setDimension(adviceCategory, 150, 30);            
        adviceCategory.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        // adviceCategory.setAlignmentX(Component.CENTER_ALIGNMENT);     
        adviceCategoryBox.add(adviceCategory);
        panel.add(adviceCategoryBox);
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        
        // Create arrays of subcatagories associated with the advice categories
        String angerOptions[] = { 
            "I'm finding myself too quick to anger.", 
            "I have bitter hatred towards someone that I have a hard time forgiving.", 
            "I'm worried that my anger will end up hurting my relationships.", 
            "I have a substance abuse problem because of my anger management issues.", 
            "I got someone very upset, and they closed me off. How do I go about talking to them?" 
        };
        String stressOptions[] = { 
            "I have too many things going on my schedule.", 
            "I feel anxious about my final projects and exams.", 
            "I'm worried about what people think of me.", 
            "I've done something wrong and I can't get myself to confess.", 
            "I'm pressed for time on an important task." 
        };
        String relationshipOptions[] = { 
            "I'm going through a breakup.", 
            "I have a sour relationship with my parents.",  
            "I'm in a toxic relationship.", 
            "My Ex won't stop bugging me and begging me to come back." 
        };
        String depressionOptions[] = { 
            "I'm going through a loss.", 
            "I'm feeling lonely.", 
            "I'm feeling depressed and I don't know why.", 
            "I get the feeling that I'm worthless.", 
            "I'm having suicidal thoughts.",
        };

        // Create a JList that will list the arrays
        JList<String> subList = new JList<>(angerOptions);
        subList.setFont(new Font("Sans-Serif", 0, 16));
        subList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add the JList to a JScrollPane
        JLabel selectLabel = GUI.text("Please Select a Prompt Below.", 250, 30, 16, Color.WHITE, "center");
        selectLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(selectLabel);
        Box subListBox = Box.createHorizontalBox();
        subListBox.add(Box.createRigidArea(new Dimension(20,0)));
        JScrollPane scrollPane = new JScrollPane(subList);
        GUI.setDimension(scrollPane, 700, 150);
        subListBox.add(scrollPane);
        subListBox.add(Box.createRigidArea(new Dimension(20,0)));
        panel.add(subListBox);
        panel.add(Box.createRigidArea(new Dimension(0,20)));

        // Have the List change depending on what is selected by the Combo Box
        adviceCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (adviceCategory.getSelectedIndex()) {
                    case 0:
                        subList.setListData(angerOptions);
                        break;
                    case 1:
                        subList.setListData(stressOptions);
                        break;
                    case 2:
                        subList.setListData(relationshipOptions);
                        break;
                    case 3:
                        subList.setListData(depressionOptions);
                    default:
                        break;
                }
            }
        });

        // Create a button to submit your options
        JButton submitButton = GUI.button("Request Advice", 300, 50, 20);
        panel.add(submitButton);
        panel.add(Box.createRigidArea(new Dimension(0,20)));

        // Add a JTextPane to add the responses for the advice
        Box responseBox = Box.createHorizontalBox();
        responseBox.add(Box.createRigidArea(new Dimension(20,0)));
        JTextPane responseText = new JTextPane();
        responseText.setAlignmentX(Component.CENTER_ALIGNMENT);
        responseText.setEditable(false);
        responseText.setFont(new Font("Sans-Serif", 0, 26));
        responseBox.add(responseText);
        responseBox.add(Box.createRigidArea(new Dimension(20,0)));
        panel.add(responseBox);
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        
        // Create a response by searching a text file. What it searches for is dependent on what Category and what Sub-Category is selected.
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String responseCode = String.valueOf(adviceCategory.getSelectedIndex()) + String.valueOf(subList.getSelectedIndex());
                System.out.println(responseCode);
                try {
                    File myObj = new File("src/edu/bushnell/termproject/onlineadvice/responses.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String line = myReader.nextLine();
                        if(line.startsWith(responseCode)){
                            // found
                            responseText.setText(line.replace((responseCode+":"), ""));
                            break;
                        } else {
                           // not found
                            responseText.setText("Could not find an appropiate response. Please try again later.");
                        }
                    }
                    myReader.close();
                  } catch (FileNotFoundException f) {
                    responseText.setText("An error occurred when accessing the Response Database. Please try again later.");
                    f.printStackTrace();
                  }
            }
        });

        panel.setVisible(true);
        return panel;
    }
    
}
