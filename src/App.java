import ui.SignInView;
import ui.registration.SignUpView;

import java.util.Scanner;
public class App {
    public void start() {
        int option;
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("1. Sign In");
            System.out.println("2. Sign Up");
            System.out.println("0. Exit");

            option = scanner.nextInt();

            switch (option) {
                case 1: {
                    SignInView signInView = new SignInView();

                    signInView.display();
                    break;
                }
                case 2: {
                    SignUpView signUpView = new SignUpView();
                    signUpView.display();
                    break;
                }
                case 0:
                    return;
                default:
                    System.out.println("Invalid input. Please enter a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        App app = new App();

        app.start();
    }
}