import java.util.*;

class aa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        int n = sc.nextInt(); 

        int originalBinary = n;
        int rem, dec = 0, i = 1;

        // Binary to Decimal
        while (n != 0) {
            rem = n % 10;
            dec = dec + rem * i;
            i = i * 2;
            n = n / 10;
        }

        // Decimal to Octal
        int oct = 0;
        int place = 1;
        int temp = dec;

        while (temp > 0) {
            int remainder = temp % 8;
            oct += remainder * place;
            temp = temp / 8;
            place *= 10;
        }

        System.out.println("Binary input: " + originalBinary);
        System.out.println("Decimal: " + dec);
        System.out.println("Octal: " + oct);
    }
}
