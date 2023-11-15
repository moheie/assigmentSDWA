package provider.client.wallet;

import user.UserDetails;

import java.util.HashMap;

public class CIBWalletClient extends WalletProviderClient {
    private String apiURL = "https://cibeg.com/api";

    @Override
    public boolean verify(UserDetails userDetails) {
        HashMap<String, String> requestParams = new HashMap<>();
        HashMap<String, String> providerData = userDetails.getProviderData();

        requestParams.put("phone_number", userDetails.getPhone());
        requestParams.put("pin_code", providerData.get("pin_code"));

        String url = apiURL + "/verify";

        HashMap<String, String> response = request(url, "POST", requestParams);

        return response.get("valid").equals("yes");
    }
}
