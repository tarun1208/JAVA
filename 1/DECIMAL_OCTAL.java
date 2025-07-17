import java.util.*;

class DecimalToOctal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int n = sc.nextInt();

        int octal = 0;
        int place = 1;

        if (n == 0) {
            octal = 0;
        } else {
            while (n > 0) {
                int rem = n % 8;
                octal += rem * place;
                n = n / 8;
                place *= 10;
            }
        }

        System.out.println("Octal of " + n + " is: " + octal);
    }
}
