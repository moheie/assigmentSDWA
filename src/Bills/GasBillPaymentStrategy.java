package Bills;

public class GasBillPaymentStrategy implements BillPaymentStrategy {
    @Override
    public void processBillPayment(long amount) {
        System.out.println("Processing Gas Bill Payment: $" + amount);
    }
}