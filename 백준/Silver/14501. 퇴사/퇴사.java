import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] time = new int[num + 1];
        int[] profit = new int[num + 1];
        int[] dp = new int[num + 2];

        for(int i = 1; i <= num; i++) {
            time[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }

        for(int i = 1; i <= num; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            if(i + time[i] <= num + 1) {
                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + profit[i]);
            }
        }
        System.out.println(Math.max(dp[num], dp[num + 1]));
    }
}
