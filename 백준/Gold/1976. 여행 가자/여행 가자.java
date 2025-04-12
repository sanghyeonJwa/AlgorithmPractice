import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 도시 수
        int M = Integer.parseInt(br.readLine());    // 여행 계획 속 도시 수
        int[][] graph = new int[N][N];

        /*
        여행 계획표에 있는 도시들이 같은 그래프 연결요소 안에 있는지 확인하면 된다.
         */

        for(int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] travel = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        boolean check = true;
        int start = find(travel[0] - 1);

        for(int i = 1; i < M; i++) {
            if(find(travel[i] - 1) != start) {
                check = false;
                break;
            }
        }

        System.out.println(check ? "YES" : "NO");

    }

    static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if(a != b) {
            parent[b] = a;
        }
    }
}
