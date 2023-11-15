package user;

import Bills.BillView;
import db.UserDB;
import provider.client.ProviderClient;
import ui.View;
import util.Session;
import java.util.Scanner;

public abstract class UserView extends View {
    protected Session session =Session.getInstance();
    protected Scanner scanner =new Scanner(System.in);
    protected User user = session.getUser();
    protected UserDetails userDetails = user.getDetails();
    protected void showBalance()
    {
        System.out.println("Your bank account balance: $" + userDetails.getBalance());
    }

    protected void payBills(){
        View view = new BillView();
        view.display();
    }

    protected void transferToAccount(){
        UserDB userDB = UserDB.getInstance();

        System.out.println("Enter username to send the money");
        String username =scanner.next();

        if(userDB.has(username)){
            System.out.println("Enter the amount of money you want to send");
            long balance = scanner.nextLong();

            if(userDetails.getBalance()<balance){
                System.out.println("You don't have this amount");
                return;
            }
            else{
                userDetails.setBalance(userDetails.getBalance()-balance);
                User newUser = userDB.get(username);
                UserDetails newUserDsetails = newUser.getDetails();
                newUserDsetails.setBalance(newUserDsetails.getBalance()+balance);
                System.out.println("Done");
                return;
            }
        }
        System.out.println("This user doesn't exist");
    }

    protected void transferToWallet(){
        ProviderClient providerClient = session.getUser().getProviderClient();
        providerClient.transfer();
    }
}
