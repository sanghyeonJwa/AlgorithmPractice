import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        System.out.println(calculate(num));
    }

    public static int calculate(int num) {

        int[] path = new int[num + 1];

        path[1] = 0;

        for(int i = 2; i <= num; i++) {

            path[i] = path[i - 1] + 1;

            if(i % 3 == 0) {
                path[i] = Math.min(path[i], path[i / 3] + 1);
            }
            if(i % 2 == 0) {
                path[i] = Math.min(path[i], path[i /2] + 1);
            }
        }

        return path[num];
    }
}
