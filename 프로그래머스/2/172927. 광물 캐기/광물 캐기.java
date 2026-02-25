import java.util.*;

class Solution {
    
    static int ans = 0;
    static int pickaxe = 0; // 곡괭이 총 개수
    
    static class Group {
        int stone, metal, dia;
        int score;
        
        Group(int stone, int metal, int dia) {
            this.stone = stone;
            this.metal = metal;
            this.dia = dia;
            this.score = stone + metal * 5 + dia * 25;
        }
    }
    
    // 곡괭이는 광물 5개를 캐면 더 못 사용
    
    public int solution(int[] picks, String[] minerals) {
        
        for(int pick : picks) {
            pickaxe += pick;
        }
        
        int len = pickaxe * 5 > minerals.length ? minerals.length : pickaxe * 5;
        
        List<Group> gps = new ArrayList<>();
        
        for(int x = 0; x < len; x += 5) {
            
            int d = 0, m = 0, s = 0;
            
            for(int y = x; y < x + 5 && y < len; y++) {
                
                String str = minerals[y];
                if(str.equals("diamond")) d++;
                else if(str.equals("iron")) m++;
                else s++;
            }
            
            gps.add(new Group(s, m, d));
        }
        
        gps.sort((a,b) -> Integer.compare(b.score, a.score));
        
        int diaPick = picks[0], metalPick = picks[1], stonePick = picks[2];
        
        for(Group gr : gps) {
            if(diaPick > 0) {
                ans += gr.dia + gr.metal + gr.stone;
                diaPick--;
            }
            else if(metalPick > 0) {
                ans += gr.dia * 5 + gr.metal + gr.stone;
                metalPick--;
            }
            else if (stonePick > 0) {
                ans += gr.dia * 25 + gr.metal * 5 + gr.stone;
                stonePick--;
            }
            else break;
        }
        
        return ans;
    }
}