package provider.client;

import user.UserDetails;

import java.net.URL;
import java.util.HashMap;

public abstract class ProviderClient {
    public abstract boolean verify(UserDetails userDetails);
    public abstract boolean transfer();

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
        }

        return response;
    }
}
