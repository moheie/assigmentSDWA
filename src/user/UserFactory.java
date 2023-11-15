package user;

public class UserFactory {
    public User createUser(UserDetails userDetails) {
        return switch (userDetails.getType()) {
            case Bank -> new BankUser(userDetails);
            case Wallet -> new WalletUser(userDetails);
        };
    }
}
