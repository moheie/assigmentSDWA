package bills;

public interface BillPaymentStrategy {
    void createBill();
    void deductFromAccount();
}