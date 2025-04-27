import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int coke = Integer.parseInt(input[0]);
        int beer = Integer.parseInt(input[1]);

        int result = coke / 2 + beer;

        if(result > N)
            System.out.println(N);
        else
            System.out.println(result);
    }
}
