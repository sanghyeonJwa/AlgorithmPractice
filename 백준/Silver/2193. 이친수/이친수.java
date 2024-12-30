
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자리 수, 3이면 3자리 수
        int N = Integer.parseInt(br.readLine());


        long[] dp0 = new long[N + 1];
        long[] dp1 = new long[N + 1];

        dp0[1] = 0;
        dp1[1] = 1;

        for(int i = 2; i <= N; i++) {
            dp0[i] = dp0[i - 1] + dp1[i - 1];
            dp1[i] = dp0[i - 1];
        }

        System.out.println(dp0[N] + dp1[N]);
    }
}
