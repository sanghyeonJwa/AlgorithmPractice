import java.util.*;
import java.io.*;

public class Main {

    static final String cry = "Padaeng_i Cry";
    static final String happy = "Padaeng_i Happy";

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());    // 돌봐야 할 시간
        int N = Integer.parseInt(br.readLine());    // 사탕 개수
        int happyTime = 0;

        int[] candyFlavors = new int[N];
        candyFlavors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int flavor : candyFlavors) {
            happyTime += flavor;
        }

        if(happyTime >= T) {
            System.out.println(happy);
        }
        else {
            System.out.println(cry);
        }
    }
}

