import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 기차 수
        int M = Integer.parseInt(input[1]); // 명령 수

        int[] trains = new int[N];

        while(M --> 0) {
            String[] commandInput = br.readLine().split(" ");
            int command = Integer.parseInt(commandInput[0]);
            int train = Integer.parseInt(commandInput[1]) - 1;

            if(command == 1) {
                int seat = Integer.parseInt(commandInput[2]);
                trains[train] |= (1 << (seat - 1));
            }

            if(command == 2) {
                int seat = Integer.parseInt(commandInput[2]);
                trains[train] &= ~(1 << (seat - 1));
            }

            if(command == 3) {
                trains[train] = (trains[train] << 1) & ((1 << 20) - 1);
            }

            if(command == 4) {
                trains[train] = trains[train] >> 1;
            }
        }

        Set<Integer> result = new HashSet<>();
        for(int train : trains) {
            result.add(train);
        }

        System.out.println(result.size());
    }
}
