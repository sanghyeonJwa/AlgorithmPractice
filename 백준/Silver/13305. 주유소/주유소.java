

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시의 개수
        int N = Integer.parseInt(br.readLine());

        int[] distance = new int[N - 1];
        int[] gas = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = 0;

        while(st.hasMoreTokens()) {
            distance[i++] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        i = 0;

        while(st.hasMoreTokens()) {
            gas[i++] = Integer.parseInt(st.nextToken());
        }

        int leastPrice = gas[0];
        int totalPrice = leastPrice * distance[0];

        for(int t = 1; t < N - 1; t++) {

            if(gas[t] < leastPrice)
                leastPrice = gas[t];

            totalPrice += leastPrice * distance[t];
        }

        System.out.println(totalPrice);
    }
}
