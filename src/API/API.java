package API;

public abstract class API {

    public abstract void processTransaction(String to,long balance);
    public abstract boolean withdraw(String from,long balance);
    public abstract boolean check(String fullnumber);

}