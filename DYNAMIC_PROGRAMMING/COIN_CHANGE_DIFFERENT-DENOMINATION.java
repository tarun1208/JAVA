import java.util.*;

public class CoinChangeWays {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of coins: ");
        int n = sc.nextInt();
        int coins[] = new int[n];
        System.out.println("Enter coin values:");
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }
        System.out.print("Enter target amount: ");
        int amount = sc.nextInt();
        int a[][] = new int[n + 1][amount + 1];
        for(int i = 0; i <= n; i++){
            a[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){

                if(coins[i-1] > j){
                    a[i][j] = a[i-1][j];
                }
                else{
                    a[i][j] = a[i-1][j] + a[i][j - coins[i-1]];
                }
            }
        }
        System.out.println("Number of ways = " + a[n][amount]);
    }
}
