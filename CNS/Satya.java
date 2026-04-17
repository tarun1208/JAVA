import java.util.*;

public class HillCipher {

    // Encrypt function
    static void encrypt(String text, int key[][]) {
        int[] msg = new int[2];
        int[] res = new int[2];

        // Convert letters to numbers
        for (int i = 0; i < 2; i++)
            msg[i] = text.charAt(i) - 'A';

        // Matrix multiplication
        for (int i = 0; i < 2; i++) {
            res[i] = 0;
            for (int j = 0; j < 2; j++) {
                res[i] += key[i][j] * msg[j];
            }
            res[i] = res[i] % 26;
        }

        // Convert back to letters
        System.out.print("Encrypted Text: ");
        for (int i = 0; i < 2; i++) {
            System.out.print((char)(res[i] + 'A'));
        }
    }

    public static void main(String[] args) {

        String text = "HI";

        int key[][] = {
            {3, 3},
            {2, 5}
        };

        encrypt(text, key);
    }
}
