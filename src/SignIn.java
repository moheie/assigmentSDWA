import java.util.Scanner;
public class SignIn {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter username: ");
    String username = scanner.next();

    System.out.println("Enter password: ");
    String password = scanner.next();


    if(true) {
        System.out.println("User successfully signed in: " + username);
    } else {
        System.out.println("Invalid credentials. Sign in failed.");
    }
}