import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());   // 가로
        int h = Integer.parseInt(st.nextToken());   // 세로

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());   // 초기 x
        int q = Integer.parseInt(st.nextToken());   // 초기 y

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());   // 시간

        /*
        w : 5 ---> 0123454321 0123454...
        h : 3 ---> 012321 012321...
         */

        int x = (p + t) % (2 * w);
        int y = (q + t) % (2 * h);

        int ansX = x <= w ? x : 2 * w - x;
        int ansY = y <= h ? y : 2 * h - y;

        System.out.println(ansX + " " + ansY);
    }
}
