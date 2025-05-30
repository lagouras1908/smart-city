import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AlphabeticalOrderScreen extends JFrame {

    public AlphabeticalOrderScreen(List<News> newsList) {
        setTitle("Alphabetical Order Screen");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<News> sortedList = newsList.stream()
                .sorted(Comparator.comparing(News::getTitle))
                .collect(Collectors.toList());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (News news : sortedList) {
            listModel.addElement(news.getTitle());
        }

        JList<String> sortedNewsJList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(sortedNewsJList);

        add(scrollPane);
    }
}
