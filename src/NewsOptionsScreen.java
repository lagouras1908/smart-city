//package java_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class NewsOptionsScreen extends JFrame {

    public NewsOptionsScreen() {
        setTitle("Κατηγορίες Ειδήσεων");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] categories = {"Τοπικά Νέα", "Αθλητικά", "Πολιτική", "Οικονομία", "Τεχνολογία"};
        JPanel panel = new JPanel(new GridLayout(categories.length, 1, 10, 10));

        for (String category : categories) {
            JButton button = new JButton(category);
            button.addActionListener((ActionEvent e) -> {
                News.processSelection(category);
                dispose(); // Close after selection
            });
            panel.add(button);
        }

        add(panel);
    }
}
