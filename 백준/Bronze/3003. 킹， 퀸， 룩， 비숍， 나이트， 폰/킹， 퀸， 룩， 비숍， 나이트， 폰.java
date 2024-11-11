import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int[] chess = new int[input.length];
        int[] needed = {1, 1, 2, 2, 2, 8};
        int[] result = new int[input.length];

        for(int i = 0; i < chess.length; i++) {
            chess[i] = Integer.parseInt(input[i]);
        }

        for(int i = 0; i < chess.length; i++) {
            result[i] = needed[i] - chess[i];
            System.out.print(result[i] + " ");
        }


        br.close();
    }
}
