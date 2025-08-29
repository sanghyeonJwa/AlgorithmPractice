
import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        baekjoon 1507 : 궁금한 민호
         */

        int n =  Integer.parseInt(br.readLine());

        map = new int[n][n];
        check = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(check[i], true);
            check[i][i] = false;
        }

        for(int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        if(floyd() == -1)
            System.out.println(-1);
        else
            System.out.println(solution() / 2);
    }

    public static int floyd() {
        for(int k = 0; k < map.length; k++) {
            for(int i = 0; i < map[k].length; i++) {
                if (i == k) continue;
                for(int j = 0; j < map[k].length; j++){
                    if (j == k || i == j) continue;
                    if(map[i][k] + map[k][j] < map[i][j]){
                        return -1;
                    }

                    if(map[i][k] + map[k][j] == map[i][j]){
                        check[i][j] = false;
                    }
                }
            }
        }

        return 1;
    }

    public static int solution() {

        int sum = 0;

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(check[i][j]) {
                    sum += map[i][j];
                }
            }
        }

        return sum;
    }
}