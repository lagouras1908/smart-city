public class ParkingSpot {
    private String ParkingSpotId;
    private String ParkingSpotLocation;
    private boolean isDisabled;

    public ParkingSpot(String ParkingSpotId, String ParkingSpotLocation, boolean isDisabled) {
        this.ParkingSpotId = ParkingSpotId;
        this.ParkingSpotLocation = ParkingSpotLocation;
        this.isDisabled = isDisabled;
    }

    public String getId() { return ParkingSpotId; }
    public String getLocation() { return ParkingSpotLocation; }
    public boolean isDisabled() { return isDisabled; }

    public boolean checkSelection() {
        return ParkingSpotId != null && !ParkingSpotId.isEmpty();
    }
}
