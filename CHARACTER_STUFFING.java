import java.util.Scanner;

public class CharacterStuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the data to be stuffed: ");
        String input = sc.next();
        System.out.print("Enter the starting delimiter character: ");
        char startDelim = sc.next().charAt(0);
        System.out.print("Enter the ending delimiter character: ");
        char endDelim = sc.next().charAt(0);
        String doubleStart = "" + startDelim + startDelim;
        String doubleEnd = "" + endDelim + endDelim;
        StringBuilder stuffed = new StringBuilder();
        stuffed.append(doubleStart);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == startDelim) {
                stuffed.append(doubleStart);
            } else if (ch == endDelim) {
                stuffed.append(doubleEnd);
            } else {
                stuffed.append(ch);
            }
        }
        stuffed.append(doubleEnd);
        System.out.println("Data after character stuffing: " + stuffed.toString());
        sc.close();
    }
}
