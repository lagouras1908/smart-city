public class EmergencyService {
    private String name;
    private String location;
    private String type;

    public EmergencyService(String name, String location, String type) {
        this.name = name;
        this.location = location;
        this.type = type;
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return name + " at " + location + " (" + type + ")";
    }
}
