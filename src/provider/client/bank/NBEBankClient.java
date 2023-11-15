package provider.client.bank;

import user.UserDetails;

import java.util.HashMap;

public class NBEBankClient extends BankProviderClient {
    private String apiURL = "https://nbe.com.eg/api";

    @Override
    public boolean verify(UserDetails userDetails) {
        HashMap<String, String> requestParams = new HashMap<>();
        HashMap<String, String> providerData = userDetails.getProviderData();

        requestParams.put("account_number", providerData.get("account_number"));
        requestParams.put("security_code", providerData.get("security_code"));

        String url = apiURL + "/verify";

        HashMap<String, String> response = request(url, "POST", requestParams);

        return response.get("valid").equals("yes");
    }
}
