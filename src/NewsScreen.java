//package java_project;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class NewsScreen extends JFrame {
    private List<News> newsList;

    public NewsScreen(List<News> newsList) {
        this.newsList = newsList;

        setTitle("News Screen");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (News news : newsList) {
            listModel.addElement(news.getTitle());
        }

        JList<String> newsJList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(newsJList);

        JButton alphabeticalButton = new JButton("Προβολή Αλφαβητικά");
        alphabeticalButton.addActionListener(e -> new AlphabeticalOrderScreen(newsList).setVisible(true));

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(alphabeticalButton, BorderLayout.SOUTH);

        add(panel);
    }
}
