import java.io.*;
import java.util.*;

public class Main {
    static class Shortcut {
        int start, end, length;

        public Shortcut(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Shortcut> shortcuts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if (end > D) continue;
            if (end - start <= length) continue;
            shortcuts.add(new Shortcut(start, end, length));
        }

        int[] dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }

        for (int i = 0; i <= D; i++) {
            if (i > 0) dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            for (Shortcut sc : shortcuts) {
                if (sc.start == i && sc.end <= D) {
                    dp[sc.end] = Math.min(dp[sc.end], dp[i] + sc.length);
                }
            }
        }

        System.out.println(dp[D]);
    }
}
