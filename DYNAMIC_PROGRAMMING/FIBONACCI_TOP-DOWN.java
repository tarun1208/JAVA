import java.util.*;
public class Fibonacci {
    static int fib(int n, int memo[]) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 0 || n == 1) {
            return n;
        }
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();
        int memo[] = new int[n + 1];
        Arrays.fill(memo, -1);
        int result = fib(n, memo);
        System.out.println("Fibonacci number is: " + result);
    }
}
