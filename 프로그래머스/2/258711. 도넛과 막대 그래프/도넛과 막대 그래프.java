import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        
        int maxNode = 0;
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }
        
        int[] inEdges = new int[maxNode + 1];
        int[] outEdges = new int[maxNode + 1];
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            inEdges[to]++;
            outEdges[from]++;
        }
        
        int startNode = 0;
        int donut = 0, stick = 0, eight = 0;
        
        // 시작 노드 찾기
        for (int i = 1; i <= maxNode; i++) {
            if (inEdges[i] == 0 && outEdges[i] >= 2) {
                startNode = i;
                break;
            }
        }
        
        for (int i = 1; i <= maxNode; i++) {
            if (i == startNode) continue;
            if (outEdges[i] == 0 && inEdges[i] >= 1) {
                stick++;
            } else if (outEdges[i] == 2 && inEdges[i] >= 2) {
                eight++;
            }
        }
        
        donut = outEdges[startNode] - stick - eight;
        
        return new int[]{startNode, donut, stick, eight};
    }
}