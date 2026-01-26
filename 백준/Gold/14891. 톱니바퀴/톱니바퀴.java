import java.util.*;
import java.io.*;

public class Main {

    static int[][] gears;
    static boolean[] moveCheck;
    static int[] dir;
    static int[] heads;  // 기어 4개의 12시에 있는 축의 인덱스
    static int cnt;
    static int target, way;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 기어 상태
        gears = new int[4][8];
        heads = new int[4];
        Arrays.fill(heads, 0);

        for(int i = 0; i < 4; i++) {
            String input = br.readLine();

            for(int j = 0; j < 8; j++) {
                gears[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        // 총 횟수
        cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < cnt; i++) {
            dir = new int[4];
            st = new StringTokenizer(br.readLine());
            target = Integer.parseInt(st.nextToken()) - 1;
            dir[target] = Integer.parseInt(st.nextToken());
            move();
        }

        System.out.println(calculate());
    }

    private static int calculate() {
        int result = 0;

        result += gears[0][heads[0]] == 0 ? 0 : 1;
        result += gears[1][heads[1]] == 0 ? 0 : 2;
        result += gears[2][heads[2]] == 0 ? 0 : 4;
        result += gears[3][heads[3]] == 0 ? 0 : 8;

        return result;
    }

    // 구현 함수, way가 1 이면 시계 방향, -1 이면 반시계 방향
    private static void move() {

        moveCheck = new boolean[4];
        moveCheck[target] = true;
        rotateCheck();

        for(int i = 0; i < 4; i++) {
            if(moveCheck[i]) {
                if(dir[i] == 1) {
                    heads[i] = (heads[i] + 8 - 1) % 8;
                }
                else if(dir[i] == -1) {
                    heads[i] = (heads[i] + 1) % 8;
                }
            }
        }
    }

    // 전체적으로 옮겨야 하는
    private static void rotateCheck() {
        for(int i = target; i < 3; i++) {
            if(gears[i][(heads[i] + 2) % 8] != gears[i + 1][(heads[i + 1] + 6) % 8]) {
                moveCheck[i + 1] = true;
                dir[i + 1] = -dir[i];
            }
            else break;
        }

        for(int i = target; i > 0; i--) {
            if(gears[i][(heads[i] + 6) % 8] != gears[i - 1][(heads[i - 1] + 2) % 8]) {
                moveCheck[i - 1] = true;
                dir[i - 1] = -dir[i];
            }
            else break;
        }
    }
}