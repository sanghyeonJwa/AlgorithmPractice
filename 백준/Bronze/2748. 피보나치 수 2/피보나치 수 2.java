

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 10
        String input = br.readLine();

        // dp length = 11
        // int형 타입은 너무 작아서 long 타입으로 변경
        long[] dp = new long[Integer.parseInt(input) + 1];


        // input이 0인 경우 분기 처리
        if(Integer.parseInt(input) == 0) {
            System.out.println(0);
        }
        else {
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            System.out.println(dp[Integer.parseInt(input)]);
        }
    }
}
