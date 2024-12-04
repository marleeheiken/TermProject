package edu.bushnell.termproject.clientinfo;

// Importing necessary classes for the GUI
import edu.bushnell.termproject.GUI; // Custom GUI helper class specific to the project
import java.awt.*; // Provides classes for creating graphical user interfaces
import java.net.URI; // For handling and opening URLs
import java.util.Random; // For generating random data
import javax.swing.*; // For creating and managing Swing components (e.g., JPanel, JButton)


/**
 * The ClientInformation class represents the graphical user interface (GUI) for collecting
 * and managing client information. It includes components for input fields, buttons,
 * validation, and actions like form submission, reset, and random data generation.
 */
public class ClientInformation {


    /**
    * Constructs the main GUI panel for the client information form.
    * This method creates a JPanel using a BorderLayout to structure the content
    * into three sections: a title at the top, form fields in the center, and action
    * buttons at the bottom.
    *
    * @return A JPanel containing the complete layout for the client information form.
    */
    public static JPanel MakeGUI() {
        // Create the main panel with a BorderLayout to organize components
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#011E40")); // Set the background color to navy blue

        // Add the title section to the top of the panel
        panel.add(createTitleSection(), BorderLayout.NORTH);

        // Create and add the form section to the center of the panel
        Box formBox = createFormBox();
        panel.add(formBox, BorderLayout.CENTER);

        // Add the button panel to the bottom of the panel
        panel.add(createBottomPanel(formBox), BorderLayout.SOUTH);

        // Return the fully constructed panel
        return panel;
    }


    /**
    * Creates the title section of the GUI.
    * This section includes a vertically aligned box with a title text.
    *
    * @return A Box containing the title section components.
    */
    private static Box createTitleSection() {
        // Create a vertical box to stack elements in the title section
        Box titleBox = Box.createVerticalBox();
        titleBox.setAlignmentX(Component.CENTER_ALIGNMENT); // Center-align the title

        // Add vertical spacing above the title
        titleBox.add(Box.createRigidArea(new Dimension(0, 25)));

        // Add the title text with specified dimensions, font size, color, and alignment
        titleBox.add(GUI.text("Client Information", 400, 30, 26, Color.WHITE, "center"));

        // Add vertical spacing below the title
        titleBox.add(Box.createRigidArea(new Dimension(0, 50)));

        // Return the fully constructed title section
        return titleBox;
    }

    /**
    * Creates the form section of the GUI.
    * This section includes input fields for various client details, such as name,
    * email, phone number, and other attributes.
    *
    * @return A Box containing the form fields and related components.
    */
    private static Box createFormBox() {
    
        // Create a vertical box to stack the form fields
        Box formBox = Box.createVerticalBox();
        formBox.setAlignmentX(Component.CENTER_ALIGNMENT); // Center-align the form fields

        // Add labeled input fields to the form
        formBox.add(createFormRow("First Name:", createTextField())); // Text field for first name
        formBox.add(createFormRow("Last Name:", createTextField()));  // Text field for last name
        formBox.add(createFormRow("Email:", createTextField()));      // Text field for email
        formBox.add(createFormRow("Phone Number:", createTextField())); // Text field for phone number
        formBox.add(createFormRow("Client Type:", createClientTypePanel())); // Radio buttons for client type
        formBox.add(createFormRow("Gender:", createGenderDropdown()));       // Dropdown for gender selection
        formBox.add(createFormRow("Date of Birth (MM/DD/YYYY):", createTextField())); // Text field for date of birth
        formBox.add(createFormRow("Password:", createPasswordField())); // Password field
        formBox.add(createTermsSection()); // Add terms and conditions section

        // Return the fully constructed form section
        return formBox;
    }


        /**
        * Creates a single row in the form consisting of a label and an input field.
        * This method is used to structure individual form elements with a consistent layout.
        *
        * @param labelText The text to display in the label (e.g., "First Name:", "Email:").
        * @param field The input component associated with the label (e.g., JTextField, JComboBox).
        * @return A Box containing the label and input field aligned horizontally.
        */
        private static Box createFormRow(String labelText, Component field) {
        // Create a horizontal box layout to place the label and input field side by side
        Box row = Box.createHorizontalBox();

        // Create a styled label with specified dimensions, font size, and color
        JLabel label = GUI.text(labelText, 300, 30, 16, Color.WHITE, "left");
        label.setForeground(Color.WHITE); // Ensure the label text is white for visibility

        // Add the label to the row
        row.add(label);

        // Add a spacer between the label and the input field for proper alignment
        row.add(Box.createRigidArea(new Dimension(20, 0)));

        // Add the input field (e.g., text field, dropdown) to the row
        row.add(field);

        // Set the maximum size of the row to ensure consistent dimensions across all rows
        row.setMaximumSize(new Dimension(700, 40));

        // Return the constructed row containing the label and field
        return row;
    }


    /**
 * Creates the terms and conditions section of the form.
 * This section includes a checkbox for agreeing to the terms and a clickable label
 * that links to the terms and conditions URL.
 *
 * @return A Box containing the terms and conditions components.
 */
private static Box createTermsSection() {
    // Create a horizontal box to align the checkbox and label side by side
    Box termsBox = Box.createHorizontalBox();

    // Set the maximum size of the terms section to ensure consistency in layout
    termsBox.setMaximumSize(new Dimension(700, 40));

    // Create a checkbox for agreeing to the terms
    JCheckBox termsCheckbox = new JCheckBox();
    termsCheckbox.setBackground(Color.decode("#011E40")); // Set the background color to match the form's theme

    // Define the URL for the terms and conditions
    String termsUrl = "https://www.random.org/terms/2020-08-01/privacy";

    // Create a styled label with an embedded hyperlink for the terms and conditions
    JLabel termsLabel = new JLabel(
            "<html><a style='color:white; text-decoration:underline;' href='" + termsUrl + "'>I agree to the terms and conditions.</a></html>");
    termsLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand pointer to indicate a clickable link

    // Add a mouse listener to the label to handle clicks
    termsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            openLink(termsUrl); // Open the terms URL in the default web browser when clicked
        }
    });

    // Add the checkbox to the terms section
    termsBox.add(termsCheckbox);

    // Add a spacer for separation between the checkbox and the label
    termsBox.add(Box.createRigidArea(new Dimension(10, 0)));

    // Add the terms label (clickable link) to the terms section
    termsBox.add(termsLabel);

    // Return the constructed terms section
    return termsBox;
}


   /**
 * Creates the bottom panel containing action buttons for the form.
 * This panel includes Submit, Reset, and Random Fill buttons, each with their respective actions.
 *
 * @param formBox The form Box containing the input fields to interact with.
 * @return A JPanel containing the action buttons.
 */
private static JPanel createBottomPanel(Box formBox) {
    // Create the bottom panel with BorderLayout to organize components
    JPanel bottomPanel = new JPanel(new BorderLayout());
    bottomPanel.setBackground(Color.decode("#011E40")); // Set background color to navy blue

    // Create buttons with specified dimensions and text
    JButton submitButton = GUI.button("Submit", 200, 50, 16); // Button to submit the form
    JButton resetButton = GUI.button("Reset", 200, 50, 16);   // Button to reset the form
    JButton randomFillButton = GUI.button("Random Fill", 100, 30, 12); // Button to auto-fill the form with random data

    // Attach action listeners to the buttons
    submitButton.addActionListener(e -> handleSubmit(formBox)); // Submit button listener
    resetButton.addActionListener(e -> handleReset(formBox));   // Reset button listener
    randomFillButton.addActionListener(e -> handleRandomFill(formBox)); // Random fill button listener

    // Create a container for the Submit and Reset buttons
    JPanel actionBox = new JPanel();
    actionBox.setBackground(Color.decode("#011E40")); // Match the background color of the panel
    actionBox.add(submitButton); // Add the Submit button to the action box
    actionBox.add(Box.createRigidArea(new Dimension(30, 0))); // Add spacing between the buttons
    actionBox.add(resetButton); // Add the Reset button to the action box

    // Add the action box to the center of the bottom panel
    bottomPanel.add(actionBox, BorderLayout.CENTER);

    // Add the Random Fill button to the left side of the bottom panel
    bottomPanel.add(randomFillButton, BorderLayout.WEST);

    // Return the constructed bottom panel
    return bottomPanel;
}

/**
 * Opens a given URL in the user's default web browser.
 *
 * @param url The URL to be opened.
 */
private static void openLink(String url) {
    try {
        // Attempt to open the URL in the default browser
        Desktop.getDesktop().browse(new URI(url));
    } catch (Exception ex) {
        // Display an error message if the link cannot be opened
        JOptionPane.showMessageDialog(null, "Unable to open the link.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

/**
 * Handles the form submission process.
 * Validates the form inputs and displays a success or error message based on the validation results.
 *
 * @param formBox The form Box containing the input fields to validate and submit.
 */
private static void handleSubmit(Box formBox) {
    // Validate the form inputs
    if (validateForm(formBox)) {
        // Show a success message if the form is valid
        JOptionPane.showMessageDialog(null, "Form has been submitted!", "Submit", JOptionPane.INFORMATION_MESSAGE);
        resetForm(formBox); // Reset the form after submission
    } else {
        // Show an error message if the form has invalid inputs
        JOptionPane.showMessageDialog(null, "Please review your form and correct any errors.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    /**
 * Validates the input fields in the form.
 * Checks whether all required fields are filled out correctly and highlights any invalid fields.
 * 
 * @param formBox The form Box containing all input fields to be validated.
 * @return True if all inputs are valid, false otherwise.
 */
private static boolean validateForm(Box formBox) {
    boolean isValid = true; // Initialize validation status to true

    // Get all components in the formBox (rows of input fields)
    Component[] components = formBox.getComponents();
    for (Component component : components) {
        // Check if the current component is a Box (container for individual rows)
        if (component instanceof Box) {
            // Iterate through the components (label and input field) in each row
            for (Component rowComponent : ((Box) component).getComponents()) {
                // Validate JTextField components (e.g., First Name, Email)
                if (rowComponent instanceof JTextField) {
                    JTextField textField = (JTextField) rowComponent;
                    if (textField.getText().trim().isEmpty()) { // Check if the field is empty
                        textField.setBackground(Color.PINK); // Highlight invalid field with pink background
                        isValid = false; // Mark form as invalid
                    } else {
                        textField.setBackground(Color.WHITE); // Reset background for valid fields
                    }
                }
                // Validate JComboBox components (e.g., Gender dropdown)
                else if (rowComponent instanceof JComboBox) {
                    JComboBox<?> comboBox = (JComboBox<?>) rowComponent;
                    if (comboBox.getSelectedIndex() == 0) { // Check if the default option is selected
                        comboBox.setBackground(Color.PINK); // Highlight invalid dropdown with pink background
                        isValid = false; // Mark form as invalid
                    } else {
                        comboBox.setBackground(Color.WHITE); // Reset background for valid selections
                    }
                }
                // Validate JCheckBox components (e.g., Terms and Conditions agreement)
                else if (rowComponent instanceof JCheckBox) {
                    JCheckBox checkBox = (JCheckBox) rowComponent;
                    if (!checkBox.isSelected()) { // Check if the checkbox is unchecked
                        isValid = false; // Mark form as invalid (no visual change here for checkboxes)
                    }
                }
            }
        }
    }

    // Return the overall validation status
    return isValid;
}


    /**
 * Resets the form to its initial state by clearing all input fields.
 * Displays a confirmation message after resetting the form.
 *
 * @param formBox The form Box containing the input fields to be reset.
 */
private static void handleReset(Box formBox) {
    // Reset all form fields
    resetForm(formBox);

    // Show a message dialog indicating the form has been reset
    JOptionPane.showMessageDialog(null, "Form has been reset!", "Reset", JOptionPane.INFORMATION_MESSAGE);
}

/**
 * Fills the form with randomly generated valid data for testing purposes.
 * This includes text fields, dropdowns, and checkboxes.
 *
 * @param formBox The form Box containing the input fields to be populated with random data.
 */
private static void handleRandomFill(Box formBox) {
    Random random = new Random(); // Create a random number generator

    // Get all components in the form box
    Component[] components = formBox.getComponents();
    for (Component component : components) {
        if (component instanceof Box) { // Process each row in the form
            for (Component rowComponent : ((Box) component).getComponents()) {
                if (rowComponent instanceof JTextField) { // Handle text fields
                    JTextField textField = (JTextField) rowComponent;
                    String label = getLabelText(rowComponent); // Retrieve the label associated with the field

                    // Debugging log for detected label
                    System.out.println("Detected Label: " + label);

                    // Generate random data based on the label
                    if (label != null && label.equalsIgnoreCase("Date of Birth (MM/DD/YYYY)")) {
                        int year = random.nextInt(30) + 1970; // Random year between 1970-1999
                        int month = random.nextInt(12) + 1;   // Random month 1-12
                        int day = random.nextInt(28) + 1;     // Random day 1-28
                        String dob = String.format("%02d/%02d/%04d", month, day, year);
                        textField.setText(dob); // Set random date of birth
                        System.out.println("DOB filled with: " + dob); // Debugging log
                    }

                    // Generate random data for specific labels
                    if (label != null && label.equalsIgnoreCase("First Name")) {
                        textField.setText("John"); // Random first name
                    } else if (label != null && label.equalsIgnoreCase("Last Name")) {
                        textField.setText("Doe"); // Random last name
                    } else if (label != null && label.equalsIgnoreCase("Email")) {
                        textField.setText("john.doe" + random.nextInt(100) + "@example.com"); // Random email
                    } else if (label != null && label.equalsIgnoreCase("Phone Number")) {
                        textField.setText("503" + (random.nextInt(9000000) + 1000000)); // Random 10-digit phone number
                    } else if (label != null && label.equalsIgnoreCase("Password")) {
                        textField.setText("Password" + random.nextInt(1000)); // Random password
                    }
                } else if (rowComponent instanceof JComboBox) { // Handle dropdowns
                    JComboBox<?> comboBox = (JComboBox<?>) rowComponent;
                    comboBox.setSelectedIndex(random.nextInt(comboBox.getItemCount() - 1) + 1); // Select random valid option
                } else if (rowComponent instanceof JCheckBox) { // Handle checkboxes
                    JCheckBox checkBox = (JCheckBox) rowComponent;
                    checkBox.setSelected(true); // Check the box
                }
            }
        }
    }

    // Show a message dialog indicating the form has been filled with random data
    JOptionPane.showMessageDialog(null, "Random valid data has been filled!", "Random Fill", JOptionPane.INFORMATION_MESSAGE);
}

/**
 * Resets all form fields to their default or initial values.
 * Clears text fields, resets dropdowns, and deselects checkboxes.
 *
 * @param formBox The form Box containing the input fields to reset.
 */
private static void resetForm(Box formBox) {
    // Get all components in the form box
    Component[] components = formBox.getComponents();
    for (Component component : components) {
        if (component instanceof Box) { // Process each row in the form
            for (Component rowComponent : ((Box) component).getComponents()) {
                if (rowComponent instanceof JTextField) { // Clear text fields
                    ((JTextField) rowComponent).setText("");
                } else if (rowComponent instanceof JComboBox) { // Reset dropdowns
                    ((JComboBox<?>) rowComponent).setSelectedIndex(0); // Reset to the first option
                } else if (rowComponent instanceof JCheckBox) { // Deselect checkboxes
                    ((JCheckBox) rowComponent).setSelected(false);
                } else if (rowComponent instanceof JPanel) { // Handle radio button groups
                    for (Component panelComponent : ((JPanel) rowComponent).getComponents()) {
                        if (panelComponent instanceof JRadioButton) {
                            JRadioButton radioButton = (JRadioButton) panelComponent;
                            radioButton.setSelected("Student".equals(radioButton.getText())); // Default to "Student" option
                        }
                    }
                }
            }
        }
    }
}

    

    /**
 * Creates a text field with specific dimensions and properties.
 *
 * @return A JTextField with a predefined width, height, and font size.
 */
private static JTextField createTextField() {
    return GUI.textField(20, 400, 30, 16); // Custom text field with width 20 and specified dimensions
}

/**
 * Creates a password field for secure input of passwords.
 *
 * @return A JPasswordField with a predefined width.
 */
private static JPasswordField createPasswordField() {
    return new JPasswordField(20); // Password field with width 20
}

/**
 * Creates a panel with radio buttons for selecting the client type.
 * Options include "Student", "Staff", and "Community Member".
 *
 * @return A JPanel containing the client type radio buttons.
 */
private static JPanel createClientTypePanel() {
    JPanel panel = new JPanel(); // Create a new panel
    panel.setBackground(Color.decode("#011E40")); // Set background color to navy blue

    ButtonGroup group = new ButtonGroup(); // Create a button group to group radio buttons

    // Create radio buttons for client types
    JRadioButton studentRadio = createRadioButton("Student", true); // Default selection
    JRadioButton staffRadio = createRadioButton("Staff", false);
    JRadioButton communityRadio = createRadioButton("Community Member", false);

    // Add radio buttons to the button group to ensure only one can be selected
    group.add(studentRadio);
    group.add(staffRadio);
    group.add(communityRadio);

    // Add the radio buttons to the panel
    panel.add(studentRadio);
    panel.add(staffRadio);
    panel.add(communityRadio);

    return panel; // Return the panel containing the radio buttons
}

/**
 * Creates a single radio button with specified text and selection state.
 *
 * @param text The text to display next to the radio button.
 * @param selected Whether the radio button should be selected by default.
 * @return A JRadioButton with the specified properties.
 */
private static JRadioButton createRadioButton(String text, boolean selected) {
    JRadioButton radioButton = new JRadioButton(text); // Create a radio button with the given label
    radioButton.setForeground(Color.WHITE); // Set the text color to white
    radioButton.setSelected(selected); // Set the initial selection state
    return radioButton; // Return the configured radio button
}

/**
 * Creates a dropdown menu for selecting gender.
 * The options include "Select", "Male", and "Female".
 *
 * @return A JComboBox containing gender options.
 */
private static JComboBox<String> createGenderDropdown() {
    String[] genderOptions = { "Select", "Male", "Female" }; // Define the dropdown options
    return new JComboBox<>(genderOptions); // Create and return a dropdown menu with the options
}

/**
 * Retrieves the label text associated with a given form field.
 * This method identifies the label by traversing the parent hierarchy of the component.
 *
 * @param component The input field (e.g., JTextField) whose label text is to be retrieved.
 * @return The text of the associated label, or null if no label is found.
 */
private static String getLabelText(Component component) {
    // Check if the component's parent is a Box layout (row container)
    if (component.getParent() instanceof Box) {
        Box row = (Box) component.getParent(); // Get the parent row container
        Component labelComponent = row.getComponent(0); // Get the first component in the row (assumed to be the label)
        if (labelComponent instanceof JLabel) { // Ensure the component is a JLabel
            // Return the label text, trimmed of colons and leading/trailing spaces
            return ((JLabel) labelComponent).getText().replace(":", "").trim();
        }
    }
    return null; // Return null if no label is found
}

}