import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        int flag = 1;
        int result = 0;

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        int[] roadLimits = new int[101];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            int km = Integer.parseInt(input[0]);
            int speed = Integer.parseInt(input[1]);

            for(int j = flag; j <= flag + km - 1; j++) {
                roadLimits[j] = speed;
            }

            flag += km;
        }


        flag = 1;

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            int km = Integer.parseInt(input[0]);
            int speed = Integer.parseInt(input[1]);

            for(int j = flag; j <= flag + km - 1; j++) {

                int overSpeed = speed - roadLimits[j];

                if(overSpeed > 0 && result < overSpeed)
                    result = overSpeed;
            }

            flag += km;
        }

        System.out.println(result);
    }
}
