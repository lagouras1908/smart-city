import javax.swing.*;
import java.awt.*;

public class MainMenuScreen extends JFrame {
    private String[] menuOptions;
    private String title;

    public MainMenuScreen(String[] menuOptions, String title) {
        this.menuOptions = menuOptions;
        this.title = title;
        setTitle(title);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel logoLabel = new JLabel(new ImageIcon("cityzen_icon_3.png")); 
        JLabel topRightIcon = new JLabel(new ImageIcon("weather.png")); 

        JPanel leftHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftHeader.add(logoLabel);

        JPanel rightHeader = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightHeader.add(topRightIcon);

        headerPanel.add(leftHeader, BorderLayout.WEST);
        headerPanel.add(rightHeader, BorderLayout.EAST);

        // Notification panel
        JPanel notificationPanel = new JPanel();
        JLabel notificationLabel = new JLabel("Απεργία ΜΜΜ για το επόμενο 24ωρο");
        notificationLabel.setFont(new Font("Arial", Font.BOLD, 14));
        notificationPanel.add(notificationLabel);

        // Grid with buttons
        JPanel gridPanel = new JPanel(new GridLayout(4, 3, 10, 10));
        
        for (String text : menuOptions) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 14));
            button.addActionListener(e -> handleUserChoice(text));
            gridPanel.add(button);
        }
        JButton exitButton = new JButton("Έξοδος");
        exitButton.addActionListener(e -> CityZenGui.exitApp());
        gridPanel.add(exitButton);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(notificationPanel, BorderLayout.CENTER);
        mainPanel.add(gridPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
    

    public void display() {
        setVisible(true);
    }


    public void handleUserChoice(String choice) {
        dispose(); // close main menu

        switch (choice) {
                    case "Κίνηση στους δρόμους":
                        new TrafficHomeScreen().setVisible(true);
                        break;
                    case "Ενημέρωση & Επικαιρότητα":
                        new NewsOptionsScreen().setVisible(true);
                        break;
                    case "Κράτηση θέσης στάθμευσης":
                        new ParkingLocationScreen().setVisible(true);
                        break;
                    case "Αξιοθέατα":
                        new LocationScreen().setVisible(true);
                        break;
                    case "Δρομολόγια τρένου":
                        new TrainSearchScreen().setVisible(true);
                        break;
                    case "Πολιτιστικές εκδηλώσεις":
                        new EventScreen().setVisible(true);
                        break;
                    case "Εφημερεύοντα":
                        new EmergencySelectionScreen().setVisible(true);
                        break;
                    case "Δήλωση Βλαβών":
                        new DamageOptionsScreen().setVisible(true);
                        break;
                    case "Αγγελίες":
                        JOptionPane.showMessageDialog(this, "Functionality not mapped.");
                        break;
                    case "Εύρεση κάδου απορριμμάτων":
                        new WasteBinSelectionScreen().setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Functionality not mapped.");
                }
            }
    }

