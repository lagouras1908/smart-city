
public class Traffic {
    private String roadName;
    private String flowType;

    public Traffic(String roadName, String flowType) {
        this.roadName = roadName;
        this.flowType = flowType;
    }

    public String getRoadName() { return roadName; }
    public String getFlowType() { return flowType; }

    @Override
    public String toString() {
        return roadName + " - Flow: " + flowType;
    }
}
