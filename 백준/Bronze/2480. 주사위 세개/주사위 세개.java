import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int[] diceNumbers = new int[7];
        int result = 0;

        for(int i = 0; i < 3; i++) {
            diceNumbers[Integer.parseInt(input[i])]++;
        }

        for(int i = 0; i < diceNumbers.length; i++) {
            if(diceNumbers[i] == 3) {
                result = 10000 + i * 1000;
                break;
            }
            else if(diceNumbers[i] == 2) {
                result = 1000 + i * 100;
                break;
            }
            else if (diceNumbers[i] == 1)
                result = i * 100;
        }

        System.out.println(result);

        br.close();
    }
}
