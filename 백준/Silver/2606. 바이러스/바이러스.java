import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 정점 개수
        int vertex = sc.nextInt();
        // 간선 개수
        int edge = sc.nextInt();

        // 초기에는 인접행렬로 생각, 인접 리스트가 더 효과적 (메모리)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] visited;
        visited = new boolean[vertex + 1];
        int count = 0;

        // 그래프 초기화
        for(int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력, (연결된 노드들의 정보)
        for(int i = 0; i < edge; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;

        while(!stack.isEmpty()) {
            int node = stack.pop();

            for(int i = graph.get(node).size() - 1; i >= 0; i--) {
                int nextNode = graph.get(node).get(i);
                if(!visited[nextNode]) {
                    visited[nextNode] = true;
                    stack.push(nextNode);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
