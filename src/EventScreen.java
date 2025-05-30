import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class EventScreen extends JFrame {
    private int eventId;
    private JList<String> eventList;
    private DefaultListModel<String> listModel;
    private List<Event> events;

    public EventScreen() {
        setTitle("Πολιτιστικές Εκδηλώσεις");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listModel = new DefaultListModel<>();
        eventList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(eventList);
        add(scrollPane);

        loadEvents();  // Auto-load events on screen open

        eventList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    selectEvent();
                }
            }
        });

        setVisible(true);
    }

    // Load upcoming events from the Database and display
    private void loadEvents() {
        events = DataBase.searchUpcomingEvents();

        if (events.isEmpty()) {
            new FailScreen().setVisible(true);
            dispose();
            return;
        }

        for (Event ev : events) {
            listModel.addElement(ev.getTitle());
        }
    }

    // Handle event selection
    private void selectEvent() {
        int index = eventList.getSelectedIndex();
        if (index >= 0) {
            Event selectedEvent = events.get(index);
            if (selectedEvent.checkSelection()) {
                String link = DataBase.getEventLink(selectedEvent.getId());
                if (link != null && !link.isEmpty()) {
                    new EventInfoScreen().displayEventInfo(selectedEvent.getTitle(), link);
                } else {
                    new FailScreen().setVisible(true);
                }
            } else {
                new FailScreen().setVisible(true);
            }
        }
    }
}
