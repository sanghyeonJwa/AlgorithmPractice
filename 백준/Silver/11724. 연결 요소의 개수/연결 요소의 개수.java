import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[nodes + 1];

        for(int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int count = 0;

        for (int i = 1; i <= nodes; i++) {
            if (!visited[i]) {
                count++;
                dfsStack(i, graph, visited);
            }
        }

        System.out.println(count);
    }

    private static void dfsStack(int start, List<List<Integer>> graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}
