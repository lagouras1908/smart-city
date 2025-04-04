package java_project;

import javax.swing.*;
import java.awt.*;

public class cityzen_gui {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CityzenHomeScreen().setVisible(true));
    }
}

class CityzenHomeScreen extends JFrame {
    public CityzenHomeScreen() {
        setTitle("Cityzen");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel logoLabel = new JLabel(new ImageIcon("java_project/cityzen_icon_3.png")); 
        JLabel topRightIcon = new JLabel(new ImageIcon("java_project/weather.png")); 
        
        JPanel leftHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftHeader.add(logoLabel);
       
        JPanel rightHeader = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightHeader.add(topRightIcon);
        
        headerPanel.add(leftHeader, BorderLayout.WEST);
        headerPanel.add(rightHeader, BorderLayout.EAST);
        
        // Ektakta panel
        JPanel notificationPanel = new JPanel();
        JLabel notificationLabel = new JLabel("Aπεργία ΜΜΜ για το επόμενο 24ωρο");
        notificationLabel.setFont(new Font("Arial", Font.BOLD, 14));
        notificationPanel.add(notificationLabel);
       
        JPanel gridPanel = new JPanel(new GridLayout(4, 3, 10, 10));
        String[] buttonTexts = {
            "Κίνηση στους δρόμους", "Ενημέρωση & Επικαιρότητα", "Κράτηση θέσης στάθμευσης",
            "Αξιοθέατα", "Δρομολόγια τρένου", "Πολιτιστικές εκδηλώσεις",
            "Εφημερεύοντα", "Δήλωση Βλαβών", "Αγγελίες",
            "Εύρεση κάδου απορριμμάτων"
        };
        
        for (String text : buttonTexts) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 14));
            gridPanel.add(button);
        }
        
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(notificationPanel, BorderLayout.CENTER);
        mainPanel.add(gridPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
}

