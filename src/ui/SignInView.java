package ui;

import user.User;
import db.UserDB;

import java.util.Scanner;
public class SignInView extends View {
    private UserDB userDB = UserDB.getInstance();

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        do {
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            User user = userDB.get(username);
            if (user == null || !user.checkPassword(password)) {
                System.out.println("Invalid credentials. Sign in failed.");
                System.out.println("1. Try Again");
                System.out.println("0. Exit");
                option = scanner.nextInt();
            } else {
                View userView = user.getView();
                userView.display();
                return;
            }
        } while (option != 0);
    }
    private void displayUserView(User user) {
        View userView = user.getView();
        userView.display();
    }
}