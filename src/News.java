//package java_project;

import java.util.List;

public class News {
    private String title;
    private String type;
    private int Id;

    public News(int Id, String title, String type) {
        this.title = title;
        this.type = type;
        this.Id = Id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return Id;
    }

    public static void processSelection(String category) {
        List<News> newsList = DataBase.CheckNewsAvailability(category);
        if (newsList.isEmpty()) {
            new FailScreen().setVisible(true);
        } else {
            new NewsScreen(newsList).setVisible(true);
        }
    }
}
