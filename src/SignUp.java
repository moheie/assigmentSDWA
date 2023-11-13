import java.util.Scanner;
public class SignUp {
    String input;
    Scanner scanner = new Scanner(System.in);
    public boolean check()
    {
        System.out.println("choose 1 if you are a using bank, 2 if wallet and exit to exit");
        input = scanner.next();
        boolean flag = true;
        do {
            switch (input)
            {
                case"1":
                {
                    //check with bank API
                    break;
                }
                case"2":
                {
                    //check with wallet API
                    break;
                }
                case"exit":
                {
                    flag = false;
                    break;
                }
                default:
                {
                    System.out.println("invalid input");
                }
            }
        }while (flag);
        return true;
    }

    public void run()
    {
        boolean check = check();
        if(check)
        {
            System.out.println("enter your user name");
            String userName = scanner.next();

            if(true) // in here we will check if the username exist
            {
                System.out.println("enter your user password");
                String password = scanner.next();

                System.out.println("Confirm your password");
                String confirmPassword = scanner.next();
                if(password.equals(confirmPassword))
                {
                    //create account
                }
            }
            else{
                System.out.println("user name is already in use");
            }
        }
    }

}
