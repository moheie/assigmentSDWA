import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        signFacade signFacade = new signFacade();
        String input;
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("choose 1 to sing in");
            System.out.println("choose 2 to sing up");
            System.out.println("choose exit to exit");
            input = scanner.next();
            switch (input)
            {
                case"1":{
                    signFacade.runIn();
                    break;
                }
                case"2":{
                    signFacade.runUp();
                    break;
                }
                case"exit":{
                    System.exit(0);
                }
                default:{
                    System.out.println("you entered a invalid input");
                }
            }
        }
    }
}