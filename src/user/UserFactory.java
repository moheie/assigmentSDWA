package user;

public class UserFactory {
    public User createUser(String username, UserDetails userDetails) {
        return switch (userDetails.getType()) {
            case Bank -> new BankUser(username, userDetails);
            case Wallet -> new WalletUser(username, userDetails);
        };
    }
}
