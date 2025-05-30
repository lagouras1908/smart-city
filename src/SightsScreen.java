import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;

public class SightsScreen extends JFrame {
    public SightsScreen(String area) {
        setTitle("Sights in " + area);
        String[] sights = DataBase.getSights(area);
        JList<String> sightList = new JList<>(sights);
        JButton infoButton = new JButton("More Info");

        infoButton.addActionListener(e -> {
            String sight = sightList.getSelectedValue();
            String info = DataBase.getSightInfo(sight);
            if (info != null) new SightInfoScreen(info).setVisible(true);
            else new FailScreen().setVisible(true);
        });

        add(new JScrollPane(sightList), BorderLayout.CENTER);
        add(infoButton, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }
}
