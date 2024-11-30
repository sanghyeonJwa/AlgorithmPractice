import java.io.*;
import java.util.*;

public class Main {

    static char[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstInput = br.readLine().split(" ");

        int n = Integer.parseInt(firstInput[0]);
        int m = Integer.parseInt(firstInput[1]);
        int answer = 64;

        board = new char[n][m];

        for(int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i <= n - 8; i++) {
            for(int j = 0; j <= m - 8; j++) {
                answer = Math.min(answer, calculate(i, j));
            }
        }
        System.out.println(answer);
    }

    public static int calculate(int x, int y) {

        int caseW = 0;
        int caseB = 0;

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {

                char block = board[x + i][y + j];

                if ((i + j) % 2 == 0) { // 짝수 칸
                    if (block != 'W') caseW++;
                    if (block != 'B') caseB++;
                } else {
                    if (block != 'B') caseW++;
                    if (block != 'W') caseB++;
                }
            }
        }

        return Math.min(caseW, caseB);
    }
}
