package util;

import java.util.HashMap;
import java.util.Random;

public class OTPService {
    private static OTPService instance;

    public static OTPService getInstance() {
        if (instance == null) {
            instance = new OTPService();
        }
        
        return instance;
    }
    
    private String apiURL = "https://verify.twilio.com";
    private HashMap<String, String> OTPs = new HashMap<>();

    private OTPService() {}

    private String generateOTP() {
        int randomNumber = new Random().nextInt(9000) + 1000;

        return Integer.toString(randomNumber);
    }

    public void sendOTP(String phone) {
        String url = apiURL + "/" + phone;
        String otp = generateOTP();

        // simulate HTTP request here to send the OTP
        OTPs.put(phone, otp);

        System.out.println("OTP sent");
        System.out.println("[DEV] The OTP is: " + otp);
    }

    public boolean verifyOTP(String phone, String inputOTP) {
        String otp = OTPs.get(phone);

        return otp != null && otp.equals(inputOTP);
    }
}
