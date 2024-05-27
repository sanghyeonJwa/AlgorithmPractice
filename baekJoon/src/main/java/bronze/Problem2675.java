package bronze;
import java.util.*;

public class Problem2675 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int op = sc.nextInt();

        for(int i = 0; i < op; i++) {
            int iter = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();

            for(char c : str.toCharArray()) {
                for(int j = 0; j < iter; j++) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
