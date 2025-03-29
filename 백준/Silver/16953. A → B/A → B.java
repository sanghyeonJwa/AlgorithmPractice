import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        long start = Long.parseLong(input[0]);
        long end = Long.parseLong(input[1]);

        int cnt = 0;

        while(end > start) {

            if(end % 10 == 1) {
                end = (end - 1) / 10;
                cnt++;
            }
            else if(end % 2 == 0) {
                end /= 2;
                cnt++;
            }
            else {
                break;
            }
        }

        System.out.println(start == end ? cnt + 1 : -1);

    }
}
