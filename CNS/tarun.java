import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Digest {

    public static String computeSHA1(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] hashBytes = md.digest(text.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        try {
            String[] messages = {
                "Hello World",
                "Hello World!",
                "hello world",
                ""
            };

            System.out.println("======================================");
            System.out.println(" SHA-1 Message Digest Calculator");
            System.out.println("======================================");

            for (String msg : messages) {
                String digest = computeSHA1(msg);
                String label = msg.isEmpty() ? "(empty string)" : msg;

                System.out.println("Input : " + label);
                System.out.println("SHA-1 : " + digest);
                System.out.println("Length : " + (digest.length() * 4) + " bits (" + digest.length() + " hex chars)");
                System.out.println("--------------------------------------");
            }

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: SHA-1 algorithm not available.");
            e.printStackTrace();
        }
    }
}
