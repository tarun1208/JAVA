import javax.crypto.*;
import java.util.Base64;

public class DESAlgorithm {

    static SecretKey getKey() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        kg.init(56);
        return kg.generateKey();
    }

    static String process(String text, SecretKey key, int mode) throws Exception {
        Cipher c = Cipher.getInstance("DES/ECB/PKCS5Padding");
        c.init(mode, key);
        byte[] result = (mode == Cipher.ENCRYPT_MODE)
                ? c.doFinal(text.getBytes())
                : c.doFinal(Base64.getDecoder().decode(text));
        return (mode == Cipher.ENCRYPT_MODE)
                ? Base64.getEncoder().encodeToString(result)
                : new String(result);
    }

    public static void main(String[] args) throws Exception {
        String msg = "Hi! Who are you?";
        SecretKey key = getKey();

        String enc = process(msg, key, Cipher.ENCRYPT_MODE);
        String dec = process(enc, key, Cipher.DECRYPT_MODE);

        System.out.println("Original : " + msg);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}
