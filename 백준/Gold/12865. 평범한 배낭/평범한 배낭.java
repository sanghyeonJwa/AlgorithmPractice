

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 물품의 수
        int K = Integer.parseInt(input[1]); // 최대 무게

        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];

        // dp 배열, 배낭 용량이 K일 때 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        // 무게 & 가치 입력
        for(int i = 1; i <= N; i++) {
            String[] input2 = br.readLine().split(" ");
            weight[i] = Integer.parseInt(input2[0]);
            value[i] = Integer.parseInt(input2[1]);
        }


        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if (weight[i] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
