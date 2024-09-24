import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int kg = sc.nextInt();
        int bags = -1;
        int fiveBag = kg / 5;

        for (int i = fiveBag; i >= 0; i--) {
            int remainder = kg - (i * 5);
            if (remainder % 3 == 0) {
                bags = i + (remainder / 3);
                break;
            }
        }

        System.out.println(bags);
    }
}
