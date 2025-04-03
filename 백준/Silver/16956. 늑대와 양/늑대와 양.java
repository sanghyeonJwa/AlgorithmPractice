import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        String[][] pasture = new String[R][C];

        // 목장 배열 입력
        for(int i = 0; i < R; i++) {
            String[] pastureInput = br.readLine().split("");

            for(int j = 0; j < C; j++) {
                pasture[i][j] = pastureInput[j];
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean possible = true;

        for(int i = 0; i < R && possible; i++) {
            for(int j = 0; j < C && possible; j++) {
                if(pasture[i][j].equals("W")) {
                    for(int d = 0; d < 4; d++) {

                        int nextX = i + dx[d];
                        int nextY = j + dy[d];

                        if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {
                            if(pasture[nextX][nextY].equals("S")) {
                                possible = false;
                                break;
                            }
                        }
                    }
                }
            }
        }

        if(!possible) {
            System.out.println("0");
            return;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (pasture[i][j].equals(".")) {
                    pasture[i][j] = "D";
                }
            }
        }

        System.out.println("1");
        for (int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < C; j++) {
                sb.append(pasture[i][j]);
            }
            System.out.println(sb.toString());
        }

    }
}
