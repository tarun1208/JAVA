import java.util.Scanner;

public class HexToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a hexadecimal number: ");
        String hex = scanner.nextLine();

        int decimal = 0;
        int power = 0;

        // Step 1: Convert Hexadecimal to Decimal
        for (int i = hex.length() - 1; i >= 0; i--) {
            char ch = hex.charAt(i);
            int digit;

            if (ch >= '0' && ch <= '9') {
                digit = ch - '0';
            } else if (ch >= 'A' && ch <= 'F') {
                digit = ch - 'A' + 10;
            } else if (ch >= 'a' && ch <= 'f') {
                digit = ch - 'a' + 10;
            } else {
                System.out.println("Invalid hexadecimal digit: " + ch);
                return;
            }

            decimal += digit * Math.pow(16, power);
            power++;
        }

        // Step 2: Convert Decimal to Binary
        String binary = "";
        if (decimal == 0) {
            binary = "0";
        } else {
            for (; decimal > 0; decimal = decimal / 2) {
                int rem = decimal % 2;
                binary = rem + binary;  // prepend to build binary string
            }
        }

        System.out.println("Binary equivalent: " + binary);

        scanner.close();
    }
}
