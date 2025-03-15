import java.util.*;
import java.io.*;

public class Main {

    public static class coordinate {
        int x, y;

        public coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<coordinate> answer = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++) {

            long m = Long.parseLong(br.readLine());
            int x = -1;
            int y = -1;

            String binary = Long.toBinaryString(m);

            for(int j = binary.length() - 1; j >= 0; j--) {

                if(binary.charAt(j) == '1') {
                    if(x == -1) {
                        x = binary.length() - j - 1;
                        y = binary.length() - j - 1;
                    }
                    else {
                        y = binary.length() - j - 1;
                    }
                }
            }

            if(x == y) {
                x--;
                y--;
            }

            answer.add(new coordinate(x, y));
        }

        for(coordinate c : answer) {
            System.out.println(c.x + " " + c.y);
        }
    }
}
