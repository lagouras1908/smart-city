public class PaymentSystem {
    public static String askForPaymentLink(String bookingId) {
        return "https://payment.example.com/pay?id=" + bookingId;
    }

    public static boolean askForPaymentStatus(String bookingId) {
        return Math.random() < 0.9; // 90% success
    }
}
