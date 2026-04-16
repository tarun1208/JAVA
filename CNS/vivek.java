Algorithm:
1. Generate a 128-bit Blowfish secret key and store it in a JCEKS keystore file
(blowfish.jks) using the Java keytool command-line utility
2. Assign an alias (blowfishkey), a keystore password (store@123), and a key password
(key@123) during keystore creation
3. In the Java program, load the JCEKS keystore file using
KeyStore.getInstance("JCEKS")
25
4. Authenticate to the keystore using the store password and retrieve the Blowfish
SecretKey entry using the alias and key password
5. Initialize the Cipher object in ENCRYPT_MODE using
Blowfish/ECB/PKCS5Padding with the retrieved key
6. Divide the plaintext into 64-bit blocks and encrypt each block through Blowfish's 16-
round Feistel network using the P-array and four S-Boxes
7. 8. Encode the resulting ciphertext bytes to Base64 for readable output
Initialize the Cipher object in DECRYPT_MODE using the same key loaded from the
keystore
9. Decode the Base64 ciphertext and apply the Blowfish decryption by reversing the sub-
key order (P18 to P1) through all 16 rounds
10. Display the original text, key algorithm, key value, encrypted ciphertext, and decrypted
plaintext
Java Program (BlowfishKeyTool.java):
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.KeyStore;
import java.io.FileInputStream;
import java.util.Base64;
public class BlowfishKeyTool {
private static final String KEYSTORE_FILE = "blowfish.jks";
private static final String STORE_PASSWORD = "store@123";
private static final String KEY_ALIAS = "blowfishkey";
private static final String KEY_PASSWORD = "key@123";
// Load the Blowfish key from the JCEKS keystore
public static SecretKey loadKeyFromKeyStore() throws Exception {
KeyStore keyStore = KeyStore.getInstance("JCEKS");
try (FileInputStream fis = new FileInputStream(KEYSTORE_FILE)) {
keyStore.load(fis, STORE_PASSWORD.toCharArray());
26
}
KeyStore.SecretKeyEntry entry = (KeyStore.SecretKeyEntry)
keyStore.getEntry(
KEY_ALIAS,
new KeyStore.PasswordProtection(KEY_PASSWORD.toCharArray())
);
return entry.getSecretKey();
}
// Encrypt plaintext using the loaded Blowfish key
public static String encrypt(String plainText, SecretKey key)
throws Exception {
Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
cipher.init(Cipher.ENCRYPT_MODE, key);
byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
return Base64.getEncoder().encodeToString(encryptedBytes);
}
// Decrypt ciphertext using the loaded Blowfish key
public static String decrypt(String cipherText, SecretKey key)
throws Exception {
Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
cipher.init(Cipher.DECRYPT_MODE, key);
byte[] decryptedBytes =
cipher.doFinal(Base64.getDecoder().decode(cipherText));
return new String(decryptedBytes, "UTF-8");
}
public static void main(String[] args) {
27
try {
String plainText = "Hello World";
System.out.println("Original Text : " + plainText);
// Load key from keystore
SecretKey secretKey = loadKeyFromKeyStore();
System.out.println("Key Algorithm : " + secretKey.getAlgorithm());
System.out.println("Key (Base64) : " +
Base64.getEncoder().encodeToString(secretKey.getEncoded()));
// Encrypt
String encrypted = encrypt(plainText, secretKey);
System.out.println("Encrypted Text : " + encrypted);
// Decrypt
String decrypted = decrypt(encrypted, secretKey);
System.out.println("Decrypted Text : " + decrypted);
} catch (Exception e) {
System.out.println("Error: " + e.getMessage());
e.printStackTrace();
}
}
}
Output:
Original Text : Hello World
Key Algorithm : Blowfish
Key (Base64) mK3pN7qR2sT4uV6w= (stored in blowfish.jks keystore)
Encrypted Text : Xz8aB1cD3eF5gH7i= (sample - depends on stored key)
Decrypted Text : Hello World
