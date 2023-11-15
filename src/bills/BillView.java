package bills;

import ui.View;

import java.util.Scanner;

public class BillView extends View {

    public void display() {
        System.out.println("Select to Pay Your Bills Using instapay!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Pay Electric Bill");
        System.out.println("2. Pay Gas Bill");
        System.out.println("3. Pay Water Bill");
        System.out.println("0. Logout");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                ElectricityBillPaymentStrategy elc = new ElectricityBillPaymentStrategy();
                elc.createBill();
                elc.deductFromAccount();
                break;
            case 2:
                GasBillPaymentStrategy gas = new GasBillPaymentStrategy();
                gas.createBill();
                gas.deductFromAccount();
                break;
            case 3:
                WaterBillPaymentStrategy wat = new WaterBillPaymentStrategy();
                wat.createBill();
                wat.deductFromAccount();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
}

