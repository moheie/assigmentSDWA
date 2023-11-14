package User;
public class userdetails {
    private String password;
    private String pin;
    private String phone;
    private String type;
    private Providers providers;
    private String accontNumber;
    private long balance;

    public userdetails() {
        password = "";
        phone = "";
        pin = "";
        type = "";
        accontNumber = "";
        balance = 0;
    }

    public userdetails(String password, String pin, String phone, String Type, Providers providers, String accontNumber) {
        this.password = password;
        this.pin = pin;
        this.phone = phone;
        this.type = Type;
        this.providers = providers;
        this.accontNumber = accontNumber;
    }

    public String getPassword()
    {
        return password;
    }

    public String getPin()
    {
        return pin;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getType()
    {
        return type;
    }

    public Providers getProviders()
    {
        return providers;
    }

    public String getAccontNumber()
    {
        if(type.equals("bank"))
            return accontNumber;
        return "";
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
