import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int L = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        int[] pipe = new int[N];

        for(int i = 0; i < N; i++) {
            pipe[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(pipe);

        int tapeCnt = 0;
        int i = 0;

        while(i < N) {
            tapeCnt++;

            int coverRange = pipe[i] + L - 1;

            while(i < N && pipe[i] <= coverRange) {
                i++;
            }
        }

        System.out.println(tapeCnt);
    }
}
