import java.util.*;
import java.io.*;

public class Main {

    static int[] airport;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int cnt = 0;

        airport = new int[G + 1];

        for(int i = 0; i <= G; i++) {
            airport[i] = i;
        }

        for(int i = 0; i < P; i++) {
            int gate = Integer.parseInt(br.readLine());
            int availableGate = find(gate);

            if(availableGate == 0) {
                break;
            }

            union(availableGate, availableGate - 1);
            cnt++;
        }

        System.out.println(cnt);
    }

    public static int find(int num) {
        if(airport[num] == num) return num;
        return airport[num] = find(airport[num]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        airport[a] = b;
    }
}
