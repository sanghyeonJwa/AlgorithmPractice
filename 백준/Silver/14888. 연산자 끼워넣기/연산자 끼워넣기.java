import java.util.*;
import java.io.*;

public class Main {

    /*
    S1. 연산자 끼어넣기
     */

    static int N;
    static int[] numbers;
    // operators : + - X /
    // 나눗셈은 몫만 쓰기
    static int[] operators = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int idx, int current) {

        if(idx == N) {
            if(current > max) max = current;
            if(current < min) min = current;
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operators[i] == 0) continue;

            operators[i]--;

            int next, num = numbers[idx];

            if(i == 0) {
                next = current + num;
            }
            else if(i == 1) {
                next = current - num;
            }
            else if(i == 2) {
                next = current * num;
            }
            else {
                next = current / num;
            }
            dfs(idx + 1, next);
            operators[i]++;
        }
    }
}