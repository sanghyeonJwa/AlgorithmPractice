

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        baekjoon S5 : 돌 게임

        N : 돌의 개수

        1. 돌은 1개 or 3개 들고갈 수 있음
        N을 3으로 나눈 나머지가 0

        돌이 한개 -> 선공 = dp[1] = 0
        돌이 두개 -> 후공 = dp[2] = 1
        돌이 세개 -> 선공 = dp[3] = 0
        4 -> 1
        5 -> 0
        6 -> 1
         */

        int N = Integer.parseInt(br.readLine());

        String answer = N % 2 == 1 ? "SK" : "CY";

        System.out.println(answer);
    }
}
