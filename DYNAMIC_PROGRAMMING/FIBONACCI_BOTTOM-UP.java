import java.util.*;
public class Fibonacci {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();
        int memo[] = new int[n + 1];
        memo[0] = 0;
        memo[1]=1;
        for(int i=2; i<=n;i++){
            memo[i] = memo[i-1]+memo[i-2];
        }
        System.out.println("Fibonacci number is: " + memo[n]);
    }
}
