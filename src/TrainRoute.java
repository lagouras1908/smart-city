import java.util.List;

public class TrainRoute {
    private String start;
    private String end;
    private String lineNumber;
    private String departureTime;
    private String duration;
    private List<Station> stops;

    public TrainRoute(String start, String end, String lineNumber, String departureTime, String duration, List<Station> stops) {
        this.start = start;
        this.end = end;
        this.lineNumber = lineNumber;
        this.departureTime = departureTime;
        this.duration = duration;
        this.stops = stops;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDuration() {
        return duration;
    }

    public List<Station> getStops() {
        return stops;
    }

    @Override
    public String toString() {
        return "Γραμμή " + lineNumber + ": " + start + " ➝ " + end;
    }
}