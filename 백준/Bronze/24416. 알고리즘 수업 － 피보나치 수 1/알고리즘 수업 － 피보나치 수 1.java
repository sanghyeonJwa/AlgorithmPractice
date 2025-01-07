

import java.util.*;
import java.io.*;

public class Main {

    static int case1 = 1;
    static int case2 = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result1 = fibonacciByRecursion(N);
        int result2 = fibonacciByDynamic(N);

        System.out.println(case1 + " " + case2);

    }

    public static int fibonacciByRecursion(int n) {

        if(n == 1 || n == 2) {
            return 1;
        }
        else {
            case1++;
            return (fibonacciByRecursion(n - 1) + fibonacciByRecursion(n - 2));
        }
    }

    public static int fibonacciByDynamic(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= n; i++) {
            case2++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
