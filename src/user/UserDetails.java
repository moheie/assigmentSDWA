package user;

import java.util.HashMap;

public class UserDetails {
    String username;
    private String password;
    private String phone;
    private UserType type;
    private Provider provider;
    private HashMap<String, String> providerData = new HashMap<>();
    private long balance;

    public UserDetails() {
        password = "";
        phone = "";
        type = UserType.Wallet;
        providerData.put("pin", "");
        balance = 0;
    }

    public UserDetails(String username,String password, String phone, UserType type, Provider provider, HashMap<String, String> providerData) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.type = type;
        this.provider = provider;
        this.providerData = providerData;
    }

    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }

    public String getPhone()
    {
        return phone;
    }

    public UserType getType()
    {
        return type;
    }

    public Provider getProvider()
    {
        return provider;
    }

    public HashMap<String, String> getProviderData() {
        return providerData;
    }

    public long getBalance()
    {
        return balance;
    }

    public void setBalance(long balance)
    {
        this.balance = balance;
    }
}
