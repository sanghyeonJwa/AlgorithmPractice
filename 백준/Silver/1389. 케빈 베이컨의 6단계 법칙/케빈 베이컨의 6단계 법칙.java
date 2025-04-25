import java.util.*;
import java.io.*;

public class Main {

    static int[][] friends;

    public static void main(String[] args) throws IOException {

        /*
        플로이드 워셜 알고리즘은 모든 정점 쌍 사이의 최단거리를 구하는 알고리즘
        음수 간선도 처리 가능
        시간 복잡도 O(N^3)

        3중 for문 구조
        제일 밖 : 경유 노드
        중간 : 출발 노드
        마지막 : 도착 노드
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        friends = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) friends[i][j] = 0;
                else friends[i][j] = 10000000;
            }
        }

        for(int i = 0; i < M; i++) {
            String[] relationshipInput = br.readLine().split(" ");
            int a = Integer.parseInt(relationshipInput[0]);
            int b = Integer.parseInt(relationshipInput[1]);

            friends[a][b] = 1;
            friends[b][a] = 1;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(friends[i][k] + friends[k][j] < friends[i][j]) {
                        friends[i][j] = friends[i][k] + friends[k][j];
                    }
                }
            }
        }

        int min = 10000000;
        int answer = -1;

        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = 1; j <= N; j++) {
                sum += friends[i][j];
            }

            if(sum < min) {
                min = sum;
                answer = i;
            }
        }

        System.out.println(answer);

    }
}
