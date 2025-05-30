import javax.swing.*;
import java.awt.*;

public class LocationScreen extends JFrame {
    public LocationScreen() {
        setTitle("City Areas");
        setLayout(new BorderLayout());

        String[] areas = DataBase.getLocations(); 
        JList<String> areaList = new JList<>(areas);
        JButton viewButton = new JButton("View Sights");
        JButton top5Button = new JButton("Top 5 Sights");

        viewButton.addActionListener(e -> new SightsScreen(areaList.getSelectedValue()).setVisible(true));
        top5Button.addActionListener(e -> new Top5SightsScreen(areaList.getSelectedValue()).setVisible(true));

        add(new JScrollPane(areaList), BorderLayout.CENTER);
        add(viewButton, BorderLayout.SOUTH);
        add(top5Button, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(null);
    }
}
