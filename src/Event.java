public class Event {
    private int id;
    private String title;

    public Event(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }

    public boolean checkSelection() {
        return id > 0 && title != null && !title.isEmpty();
    }

    @Override
    public String toString() {
        return id + ": " + title;
    }
}
