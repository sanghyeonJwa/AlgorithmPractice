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
        
        // 시작 노드의 특징 : 들어오는 간선 무조건 0, 나가는 간선 : 도형의 수
        // 도넛 그래프의 노드 특징 : ???
        // 막대 그래프의 노드 특징 : 끝 노드는 들어오는 간선 : 1,2 , 나가는간선 : 0
        // 8자 모양 그래프의 노드 특징 : 접점인 노드의 들어오는 간선과 나가는 간선이 2, 시작노드가 가리키면 들어오는 간선 + 1
        // 도넛 그래프 : 시작 노드 나가는 가선 - (막대 그래프 + 8자 그래프)
        
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