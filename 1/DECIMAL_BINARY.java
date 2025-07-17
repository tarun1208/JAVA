import java.util.*;

class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int n = sc.nextInt();
        String binary = "";

        if (n == 0) {
            binary = "0";
        } else {
            while (n > 0) {
                int rem = n % 2;
                binary = rem + binary;
                n = n / 2;
            }
        }

        System.out.println("Binary of " + n + " is: " + binary);
    }
}
