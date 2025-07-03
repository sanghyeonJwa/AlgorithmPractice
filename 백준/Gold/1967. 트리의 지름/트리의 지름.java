import java.util.*;
import java.io.*;

public class Main {

    static List<List<Node>> tree = new ArrayList<>();
    static boolean[] visited;
    static int maxDistance = 0;
    static int maxNode = 0;

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        // 초기화
        for(int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree.get(from).add(new Node(to, weight));
            tree.get(to).add(new Node(from, weight));
        }

        dfs(1);

        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(maxNode);
        System.out.println(maxDistance);
    }

    public static void dfs(int current) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(current, 0));
        visited[current] = true;

        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();

            if(currentNode.weight > maxDistance) {
                maxDistance = currentNode.weight;
                maxNode = currentNode.to;
            }

            for(Node node : tree.get(currentNode.to)) {
                if(!visited[node.to]) {
                    visited[node.to] = true;
                    stack.push(new Node(node.to, currentNode.weight + node.weight));
                }
            }
        }
    }
}
