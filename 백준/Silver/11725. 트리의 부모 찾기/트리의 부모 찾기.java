import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }
        
        int[] parent = new int[n + 1];
        dfs(tree, parent, 1);
        
        for(int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
    
    private static void dfs(ArrayList<ArrayList<Integer>> tree, int[] parent, int current) {
        for (int child : tree.get(current)) {
            if (parent[child] == 0) {
                parent[child] = current;
                dfs(tree, parent, child);
            }
        }
    }
}