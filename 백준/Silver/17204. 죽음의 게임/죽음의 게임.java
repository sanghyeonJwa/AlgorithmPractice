import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] graph = new int[N];

        // 그래프 초기화

        for(int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());
            graph[i]= v;
        }

        /*
        그래프의 정점 0부터 시작해서 K 정점에 도달하기 위한 최소의 수 구하기
        방법이 없다면 답은 -1 이다.
         */

        int pick = graph[0];
        int result = 1;

        for(int i = 0; i < N; i++) {
            if(pick == K)
                break;
            else {
                pick = graph[pick];
                result++;
            }
        }

        if(result > N)
            result = -1;

        System.out.println(result);
    }
}
