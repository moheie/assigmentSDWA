package Bills;

public abstract interface BillPaymentStrategy {
    void createBill();
    void deductFromAccount();
}