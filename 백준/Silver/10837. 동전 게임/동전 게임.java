import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 라운드 수
        int K = Integer.parseInt(br.readLine());

        // 입력 수
        int C = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < C; i++) {
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]); // 영희 (먼저 시작)
            int N = Integer.parseInt(input[1]); // 동수

            if(M == N) {
                sb.append("1\n");
                continue;
            }

            int remainingChances = K - Math.max(M, N);
            int scoreDifference = Math.abs(M - N);

            if(M > N) {
                if(scoreDifference - remainingChances <= 2) {
                    sb.append("1\n");
                }
                else {
                    sb.append("0\n");
                }
            }
            else {
                if(scoreDifference - remainingChances <= 1) {
                    sb.append("1\n");
                }
                else {
                    sb.append("0\n");
                }
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}
