import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int a, b;
        int[] diff = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            diff[i] = a - b;
        }

        Arrays.sort(diff);

        if(n % 2 == 1) {
            System.out.println(1);
        }
        else {
            int mid1 = diff[n / 2 - 1];
            int mid2 = diff[n / 2];
            System.out.println(Math.abs(mid2 - mid1) + 1);
        }

    }
}

