import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        String longStr;
        String shortStr;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int max = 0;

        /*
        두 문자열에 모두 포함된 가장 긴 공통 부분 문자열 찾기
         */

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}
