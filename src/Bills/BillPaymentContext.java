package Bills;

public class BillPaymentContext {
    private BillPaymentStrategy billPaymentStrategy;

    public BillPaymentContext(BillPaymentStrategy billPaymentStrategy) {
        this.billPaymentStrategy = billPaymentStrategy;
    }

    public void setBillPaymentStrategy(BillPaymentStrategy billPaymentStrategy) {
        this.billPaymentStrategy = billPaymentStrategy;
    }

    public void processBillPayment(long amount) {
        billPaymentStrategy.processBillPayment(amount);
    }
}