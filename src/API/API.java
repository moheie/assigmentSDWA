package API;

public abstract class API {

    public abstract void processTransaction(String to, long balance);

    void send_otp(int mobile_number) {

    }

    void verify_otp(int otp) {

    }

    // handel API URL
    protected String callExternalApi(String apiUrl, String method, String requestBody) {

        System.out.println("Calling external API: " + apiUrl);
        System.out.println("Method: " + method);
        System.out.println("Request Body: " + requestBody);
        return "API response";
    }
}
