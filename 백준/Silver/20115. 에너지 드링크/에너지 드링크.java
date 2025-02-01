

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 음료의 개수
        long N = Long.parseLong(br.readLine());

        long[] beverageAmount = new long[(int) N];

        int i = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            beverageAmount[i++] = Long.parseLong(st.nextToken());
        }

        /*
        음료의 개수가 N개 라면, N - 1개는 절반을 버려야 하는 것이다. 그러므로
        가장 큰 음료를 제외한 나머지 음료를 절반씩 버리고 더하면 된다.
         */

        Arrays.sort(beverageAmount);
        double result = beverageAmount[beverageAmount.length - 1];

        for(int t = 0; t < N - 1; t++) {
            result += (double)beverageAmount[t] / 2;
        }

        System.out.println(result);
    }
}
