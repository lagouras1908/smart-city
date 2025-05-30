public class DamageReport {
    private static int nextId = 1;

    private int id;
    private String location;
    private String description;

    public DamageReport(String location, String description) {
        this.id = nextId++;
        this.location = location;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Report ID: " + id + ", Location: " + location + ", Description: " + description;
    }
}

