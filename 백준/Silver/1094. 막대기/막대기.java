import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int cnt = 0;

        while(X > 0) {
            if((X % 2) == 1) {
                cnt++;
            }
            X >>= 1;    // X /= 2
        }

        System.out.println(cnt);
    }
}
