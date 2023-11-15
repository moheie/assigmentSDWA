package provider.client.bank;

import user.UserDetails;

import java.util.HashMap;

public class MISRBankClient extends BankProviderClient {
    private String apiURL = "https://banquemisr.com/api";

    @Override
    protected HashMap<String, String> initializeRequestParams(UserDetails userDetails) {
        HashMap<String, String> requestParams = new HashMap<>();
        HashMap<String, String> providerData = userDetails.getProviderData();

        requestParams.put("account_number", providerData.get("account_number"));
        requestParams.put("security_code", providerData.get("security_code"));

        return requestParams;
    }

    @Override
    public long getBalance(UserDetails userDetails) {
        String url = apiURL + "/balance";

        HashMap<String, String> requestParams = initializeRequestParams(userDetails);
        HashMap<String, String> response = request(url, "GET", requestParams);

        return Long.parseLong(response.get("balance"));
    }

    @Override
    public boolean verify(UserDetails userDetails) {
        String url = apiURL + "/verify";

        HashMap<String, String> requestParams = initializeRequestParams(userDetails);
        HashMap<String, String> response = request(url, "POST", requestParams);

        return response.get("valid").equals("yes");
    }

    public TransferStatus transfer(UserDetails userDetails, HashMap<String, String> targetParameters) {
        String url = apiURL + "/transfer";

        HashMap<String, String> requestParams = initializeRequestParams(userDetails);
        requestParams.putAll(targetParameters);

        HashMap<String, String> response = request(url, "POST", requestParams);

        return TransferStatus.valueOf(response.get("status"));
    }

}
