import javax.swing.*;
import java.awt.*;

public class Top5SightsScreen extends JFrame {
    public Top5SightsScreen(String area) {
        setTitle("Top 5 Sights in " + area);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] topSights = DataBase.getTop5Sights(area); // Retrieve top 5 sights
        JList<String> topList = new JList<>(topSights);
        JButton infoButton = new JButton("View Info");

        infoButton.addActionListener(e -> {
            String sight = topList.getSelectedValue();
            if (sight == null) return;

            String info = DataBase.getSightInfo(sight);
            if (info != null) {
                new SightInfoScreen(info).setVisible(true);
            } else {
                new FailScreen().setVisible(true);
            }
        });

        add(new JScrollPane(topList), BorderLayout.CENTER);
        add(infoButton, BorderLayout.SOUTH);
    }
}
