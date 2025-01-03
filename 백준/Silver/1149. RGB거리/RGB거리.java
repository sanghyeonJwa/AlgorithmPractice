import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] paintingCost = new int[N][3];

        int[] dpRed = new int[N];   // 첫집을 빨간색
        int[] dpGreen = new int[N]; // 첫집을 초록색
        int[] dpBlue = new int[N];  // 첫집을 파란색

        // Input
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; j++) {
                paintingCost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
        1번 집의 색은 2번 집의 색과 같지 않아야 한다.
        N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
        i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

        다음에 칠할 수 있는 색깔은 전에 어떤 색깔을 칠했는지에 따라서 달라진다.
         */

        // 초기화
        dpRed[0] = paintingCost[0][0];
        dpGreen[0] = paintingCost[0][1];
        dpBlue[0] = paintingCost[0][2];

        // 다이나믹 프로그래밍 시작
        for(int i = 1; i < N; i++) {
            dpRed[i] = Math.min(dpGreen[i - 1], dpBlue[i - 1]) + paintingCost[i][0];
            dpGreen[i] = Math.min(dpRed[i - 1], dpBlue[i - 1]) + paintingCost[i][1];
            dpBlue[i] = Math.min(dpRed[i - 1], dpGreen[i - 1]) + paintingCost[i][2];
        }

        System.out.println(Math.min(dpRed[N - 1], Math.min(dpGreen[N - 1], dpBlue[N - 1])));
    }
}
