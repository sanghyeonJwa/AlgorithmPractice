import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] lines = new int[13][13];
        int[] nearStarsCnt = new int[13];

        // 입력 받기
        for(int i = 0; i < 12; i++) {
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            // 그래프 입력
            lines[start][end] = 1;
            lines[end][start] = 1;

            // 연결된 별 개수 카운팅
            nearStarsCnt[start]++;
            nearStarsCnt[end]++;
        }

        for(int i = 1; i <= 12; i++) {
            if(nearStarsCnt[i] == 3) {

                int sum = 0;

                for(int j = 1; j <= 12; j++) {
                    if(lines[i][j] == 1)
                        sum += nearStarsCnt[j];
                }

                if(sum == 6) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
