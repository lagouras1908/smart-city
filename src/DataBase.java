import java.util.*;
import java.util.stream.Collectors;

public class DataBase {
    private static List<ParkingSpot> parkingSpots = new ArrayList<>();
    private static List<Event> events = new ArrayList<>();
    private static List<DamageReport> reports = new ArrayList<>();
    private static List<Traffic> trafficData = new ArrayList<>();

    static {
    trafficData.clear();
    trafficData.add(new Traffic("Πανεπιστημίου", "Κανονική"));
    trafficData.add(new Traffic("Αχιλλέως", "Κανονική"));
    trafficData.add(new Traffic("Έλληνος Στρατιώτου", "Αυξημένη"));
    trafficData.add(new Traffic("Κωνσταντινουπόλεως", "Αυξημένη"));
    trafficData.add(new Traffic("Κορίνθου", "Συμφόρηση"));
    trafficData.add(new Traffic("Παπαφλέσσα", "Συμφόρηση")); }

    private static List<EmergencyService> emergencyServices = new ArrayList<>();

    static {
        emergencyServices.clear();
    emergencyServices.add(new EmergencyService("Πανεπιστημιακό Νοσοκομείο", "Ιπποκράτους", "Hospital"));
    emergencyServices.add(new EmergencyService("Νοσοκομείο Αγίου Ανδρέα", "Καλαβρύτων", "Hospital"));
    emergencyServices.add(new EmergencyService("Νοσοκομείο Παίδων", "Γλάυκου", "Hospital"));
     emergencyServices.add(new EmergencyService("Νοσοκομείο Αγίου Αλέξη", "Γιαννιτσών", "Hospital"));
    emergencyServices.add(new EmergencyService("Φαρμακείο HealthPlus", "Ολύμπου", "Pharmacy"));
    emergencyServices.add(new EmergencyService("Φαρμακείο Green Medicine", "Πέντε Πηγαδίων", "Pharmacy"));
    emergencyServices.add(new EmergencyService("Φαρμακείο Ιωαννίδης ", "Νοταρά ", "Pharmacy"));
    emergencyServices.add(new EmergencyService("Φαρμακείο Αγγελόπουλος", "Ηρώων Πολυτεχνείου ", "Pharmacy"));
    }
    
private static List<News> newsList = new ArrayList<>();

    static {
        // Dummy data
        newsList.add(new News(1,"Ο καιρός σήμερα", "Τοπικά Νέα"));
        newsList.add(new News(2, "Νίκη της ομάδας", "Αθλητικά"));
        newsList.add(new News(3,"Αναβολή αγώνα", "Αθλητικά"));
        newsList.add(new News(4,"Νέα μέτρα στην οικονομία", "Οικονομία"));
        newsList.add(new News(5,"Κυβερνητικές εξελίξεις", "Πολιτική"));
        newsList.add(new News(6,"Καινοτομία στην τεχνολογία", "Τεχνολογία"));
    }

    public static List<News> CheckNewsAvailability(String category) {
        return newsList.stream()
                .filter(news -> news.getType().equals(category))
                .collect(Collectors.toList());
    }

    
    public static int registerReport(DamageReport report) {
        if (report.getLocation().isEmpty() || report.getDescription().isEmpty()) {
            return -1; // Invalid input
        }
        reports.add(report);
        return report.getId();
    }

    public static List<DamageReport> getAllReports() {
        return new ArrayList<>(reports);
    }
    public static List<ParkingSpot> searchAvailableSpots(String location) {
        List<ParkingSpot> result = new ArrayList<>();
        for (ParkingSpot s : parkingSpots)
            if (s.getLocation().equalsIgnoreCase(location) && !s.isDisabled())
                result.add(s);
        return result;
    }

     public static List<Traffic> getAllTraffic() {
        return trafficData;
    }

     public static List<Traffic> getTrafficByType(String type) {
        List<Traffic> result = new ArrayList<>();
        for (Traffic t : trafficData)
            if (t.getFlowType().equalsIgnoreCase(type))
                result.add(t);
        return result;
    }

    public static List<String> getRoadsByTrafficFlow(String flowType) {
    List<String> result = new ArrayList<>();
    for (Traffic t : trafficData) {
        if (t.getFlowType().equalsIgnoreCase(flowType)) {
            result.add(t.getRoadName());
        }
    }
    return result;
}
    public static List<EmergencyService> getEmergencyServices(String type) {
        List<EmergencyService> result = new ArrayList<>();
        for (EmergencyService s : emergencyServices)
            if (s.getType().equalsIgnoreCase(type))
                result.add(s);
        return result;
    }

    public static List<Event> getUpcomingEvents() {
        return events;
    }

    public static void reportDamage(DamageReport r) {
        reports.add(r);
    }

    
    private static String[][] sightsByArea = {
        {"Central Park", "City Museum", "Old Town Hall"},
        {"Harbor", "Sea Aquarium", "Light Tower"}
    };

    private static String[] areas = {"Downtown", "Seaside"};

    private static String getInfo(String sight) {
        switch (sight) {
            case "Central Park":
                return "A large public park in the city center.";
            case "City Museum":
                return "Exhibits history and culture of the city.";
            case "Old Town Hall":
                return "Historical building from the 18th century.";
            case "Harbor":
                return "Main port and walking area.";
            case "Sea Aquarium":
                return "Marine animals and fish from around the world.";
            case "Light Tower":
                return "Historic lighthouse with sea view.";
            default:
                return null;
        }
    }

    public static String[] getLocations() {
        return areas;
    }

    public static String[] getSights(String area) {
        if (area.equals("Downtown")) return sightsByArea[0];
        if (area.equals("Seaside")) return sightsByArea[1];
        return new String[]{};
    }

    public static String getSightInfo(String sight) {
        return getInfo(sight);
    }

    public static String[] getTop5Sights(String area) {
        return getSights(area);
    }

public static ParkingSpot[] searchParkingSpots(String location) {
        return new ParkingSpot[] {
            new ParkingSpot("P1", location, false),
            new ParkingSpot("P2", location, false)
        };
    }

    public static ParkingSpot[] searchParkingSpotsDisabled(String location) {
        return new ParkingSpot[] {
            new ParkingSpot("D1", location, true)
        };
    }

    public static void saveBooking(Booking booking) {
        System.out.println("Booking saved in DB: " + booking.getId());
    }
 public static String[] locationSearch() {
        return new String[] { "Downtown", "Old Town", "Marina", "University" };
    }

    public static List<Event> searchUpcomingEvents() {
        
        return List.of(
            new Event(1, "Συναυλία στο Πάρκο"),
            new Event(2, "Θεατρική Παράσταση"),
            new Event(3, "Έκθεση Τέχνης")
        );
    }

public static String getEventLink(int eventId) {
        // Simulated logic
        switch (eventId) {
            case 1: return "https://example.com/concert";
            case 2: return "https://example.com/theater";
            case 3: return "https://example.com/exhibition";
            default: return null;
        }
    }

     private static List<TrainRoute> allRoutes = new ArrayList<>();

    static {
        allRoutes.add(new TrainRoute(
            "Κέντρο", "Άγιος Βασίλης", "1001", "08:00", "30 λεπτά",
            Arrays.asList(
                new Station("Κέντρο", "08:00"),
                new Station("Αγυιά", "08:10"),
                new Station("Ρίο", "08:20"),
                new Station("Άγιος Βασίλης", "08:30")
            )
        ));

        allRoutes.add(new TrainRoute(
            "Κέντρο", "Άγιος Βασίλης", "1001", "09:00", "30 λεπτά",
            Arrays.asList(
                new Station("Κέντρο", "09:00"),
                new Station("Αγυιά", "09:10"),
                new Station("Ρίο", "09:20"),
                new Station("Άγιος Βασίλης", "09:30")
            )
        ));

        allRoutes.add(new TrainRoute(
            "Βραχνέικα", "Κέντρο", "1002", "09:30", "30 λεπτά",
            Arrays.asList(
                new Station("Βραχνέικα", "09:30"),
                new Station("Παραλία", "09:40"),
                new Station("Κέντρο", "10:00")
            )
        ));

        allRoutes.add(new TrainRoute(
            "Βραχνέικα", "Κέντρο", "1002", "14:30", "30 λεπτά",
            Arrays.asList(
                new Station("Βραχνέικα", "14:30"),
                new Station("Παραλία", "14:40"),
                new Station("Κέντρο", "15:00")
            )
        ));

        allRoutes.add(new TrainRoute(
            "Οβριά", "Κέντρο", "1003", "11:00", "1 ώρα",
            Arrays.asList(
                new Station("Οβριά", "11:00"),
                new Station("Γλάυκος", "11:30"),
                new Station("Κέντρο", "12:00")
            )
        ));

        allRoutes.add(new TrainRoute(
            "Οβριά", "Κέντρο", "1003", "17:00", "1 ώρα",
            Arrays.asList(
                new Station("Οβριά", "17:00"),
                new Station("Γλάυκος", "17:30"),
                new Station("Κέντρο", "18:00")
            )
        ));

        allRoutes.add(new TrainRoute(
            "Αρόη", "Κουκούλι", "1003", "19:00", "1 ώρα",
            Arrays.asList(
                new Station("Αρόη", "19:00"),
                new Station("Εγλυκάδα", "19:30"),
                new Station("Κουκούλι", "20:00")
            )
        ));
    }

    public static List<TrainRoute> getRoutes(String from, String to) {
        List<TrainRoute> result = new ArrayList<>();
        for (TrainRoute route : allRoutes) {
            if (route.getStart().equalsIgnoreCase(from) && route.getEnd().equalsIgnoreCase(to)) {
                result.add(route);
            }
        }
        return result;
    }

    private static List<WasteBin> bins = new ArrayList<>();

    static {
        bins.clear();
    bins.add(new WasteBin("Ανακύκλωση", "Μουρούζη","Paper, plastic, metals, glass"));
    bins.add(new WasteBin("Γενικά", "Αθηνών","Place the garbage in plastic bags, to prevent spills and odors."));
    bins.add(new WasteBin("Οργανικά", "Αράτου","Food scraps, yard waste, Biodegradable Materials"));
    bins.add(new WasteBin("Ηλεκτρικές Συσκευές", "Μαιζώνος","Designated only for out of use electronic devices."));
    bins.add(new WasteBin("Λάμπες", "Αυστραλίας","Mostly for LED and fluorescent lamps"));
    bins.add(new WasteBin("Ανακύκλωση", "Βενιζέλου","Paper, plastic, metals, glass"));
    bins.add(new WasteBin("Οργανικά", "Ανθείας","Food scraps, yard waste, Biodegradable Materials"));
    bins.add(new WasteBin("Γενικά", "Κορίνθου","Place the garbage in plastic bags, to prevent spills and odors."));
    }

      public static List<WasteBin> getBins(String category, String area) {
    return bins.stream()
        .filter(b -> b.getCategory().equalsIgnoreCase(category))
        .filter(b -> b.getArea().equalsIgnoreCase(area))
        .toList();
}

public static List<WasteBin> getAllWasteBins() {
    return bins;
}

 public static void addBin(WasteBin b) {
        bins.add(b);
    }
}

