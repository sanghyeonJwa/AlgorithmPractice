import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            people[i][0] = Integer.parseInt(info[0]);  // 몸무게
            people[i][1] = Integer.parseInt(info[1]);  // 키
        }
        
        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
