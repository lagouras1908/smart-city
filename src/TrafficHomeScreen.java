import javax.swing.*;
import java.awt.*;

public class TrafficHomeScreen extends JFrame {

    public TrafficHomeScreen() {
        setTitle("Αρχική Οθόνη Κίνησης");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        JLabel label = new JLabel("Κίνηση στο Κέντρο: Κανονική", SwingConstants.CENTER);
        add(label);

        JButton allRoadsButton = new JButton("Η κίνηση σε όλους τους δρόμους της πόλης");
        JButton byFlowButton = new JButton("Επέλεξε είδος κίνησης");
        JButton byRoadButton = new JButton("Επέλεξε δρόμο");

        add(allRoadsButton);
        add(byFlowButton);
        add(byRoadButton);

        // === ΕΝΕΡΓΕΙΕΣ ===
        allRoadsButton.addActionListener(e -> {
            TrafficInAllRoadsScreen allRoadsScreen = new TrafficInAllRoadsScreen();
            allRoadsScreen.displayAllRoadsTraffic();
        });

        byFlowButton.addActionListener(e -> {
    new SelectTrafficFlowScreen();
});

    
       byRoadButton.addActionListener(e -> {
    SelectRoadScreen roadScreen = new SelectRoadScreen();
    roadScreen.displayTrafficInSelectedRoad();
});

        setVisible(true);
    }
}
