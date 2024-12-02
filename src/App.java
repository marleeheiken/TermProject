import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.bushnell.termproject.home.HomeScreen;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("TermProject");
        HomeScreen home = new HomeScreen();
        JPanel homePanel = home.MakeGUI();
        frame.add(homePanel);
        frame.pack();   
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}