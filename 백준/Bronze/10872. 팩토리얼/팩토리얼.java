import java.util.*;

public class Main {

    public static int result =  1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        test(num);
        System.out.println(result);
    }

    public static void test(int num) {
        if(num == 0) return;
        else {
            result *= num;
            test(num - 1);
        }
    }
}
