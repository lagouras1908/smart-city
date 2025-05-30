import javax.swing.*;

public class SightInfoScreen extends JFrame {
    public SightInfoScreen(String info) {
        setTitle("Sight Info");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea infoArea = new JTextArea(info);
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        infoArea.setEditable(false);
        add(new JScrollPane(infoArea));
    }
}
