import java.util.*;
import java.io.*;

class Solution {
    
    static class Position {
        int r, c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return r == position.r && c == position.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        
        Map<Integer, Position> pointMap = new HashMap<>();
        
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, new Position(points[i][0], points[i][1]));
        }
        
        Map<Integer, Map<Position, Integer>> timePositionMap = new HashMap<>();
        
        for(int[] route : routes) { 
            int time = 0;
            Position current = pointMap.get(route[0]);
            int r = current.r;
            int c = current.c;
            
            timePositionMap.computeIfAbsent(time, k -> new HashMap<>());
            Position pos = new Position(r, c);
            timePositionMap.get(time).put(pos, timePositionMap.get(time).getOrDefault(pos, 0) + 1);
            
            for (int i = 1; i < route.length; i++) {
                Position target = pointMap.get(route[i]);
                int tr = target.r;
                int tc = target.c;

                while (r != tr) {
                    time++;
                    r += (r < tr) ? 1 : -1;
                    pos = new Position(r, c);
                    timePositionMap.computeIfAbsent(time, k -> new HashMap<>());
                    timePositionMap.get(time).put(pos, timePositionMap.get(time).getOrDefault(pos, 0) + 1);
                }
                while (c != tc) {
                    time++;
                    c += (c < tc) ? 1 : -1;
                    pos = new Position(r, c);
                    timePositionMap.computeIfAbsent(time, k -> new HashMap<>());
                    timePositionMap.get(time).put(pos, timePositionMap.get(time).getOrDefault(pos, 0) + 1);
                }
            }    
        }
        
        int answer = 0;
        for (Map<Position, Integer> positions : timePositionMap.values()) {
            for (int count : positions.values()) {
                if (count >= 2) answer++;
            }
        }

        return answer;
    }
}