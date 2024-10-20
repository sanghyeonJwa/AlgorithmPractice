import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int result = 1;

        /*
        dynamic programming

        2 x n 타일을 채우는 방법은 다음과 같다. -> dp[n]
        1. dp[n-1] 방법에 2 x 1 타일을 하나 추가하는 방법
        2. dp[n-2] 방법에 1 x 2 타일을 2개 추가하는 방법

        -> 이 관계를 이용해 점화식을 새울 수 있다.
        dp[n] = dp[n-1] + dp[n-2]
         */

        int[] dp = new int[num + 1];

        dp[1] = 1;

        if(num >= 2)
            dp[2] = 2;

        for(int i = 3; i <= num; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[num]);

    }
}
