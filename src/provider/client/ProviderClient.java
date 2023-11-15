package provider.client;

import user.UserDetails;

import java.net.URL;
import java.util.HashMap;

public abstract class ProviderClient {
    public enum TransferStatus {
        Successful,
        InsufficientFunds,
        TargetNotFound
    }

    public abstract long getBalance(UserDetails userDetails);
    public abstract boolean verify(UserDetails userDetails);
    public abstract TransferStatus transfer(UserDetails userDetails, HashMap<String, String> targetParameters);

    protected abstract HashMap<String, String> initializeRequestParams(UserDetails userDetails);

    // Send API requests
    protected HashMap<String, String> request(String strUrl, String method, HashMap<String, String> params) {
        HashMap<String, String> response = new HashMap<>();
        String path = "/";

        try {
            URL url = new URL(strUrl);

            path = url.getPath().substring(4);
        } catch (Exception e) {
            System.out.println(e);
        }

        switch (path) {
            case "/verify":
                response.put("valid", "yes");
                break;
            case "/balance":
                response.put("balance", "5000");
                break;
            case "/transfer":
                response.put("status", TransferStatus.Successful.name());
                break;
        }

        return response;
    }
}
