public class Booking {
    private String id;
    private ParkingSpot spot;

    public Booking(ParkingSpot spot) {
        this.spot = spot;
        this.id = generateBookingId();
    }

    public String getId() { return id; }
    public ParkingSpot getSpot() { return spot; }

    public void storeInDatabase() {
        DataBase.saveBooking(this);
    }

    public boolean askForPaymentStatus() {
        return PaymentSystem.askForPaymentStatus(id);
    }

    public String directToPayment() {
        return PaymentSystem.askForPaymentLink(id);
    }

    private String generateBookingId() {
        return "BOOK" + System.currentTimeMillis();
    }
}
