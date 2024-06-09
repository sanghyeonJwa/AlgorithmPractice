import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        test(num1, num2);
        System.out.println(num1 * num2);
    }

    public static void test(int num1, int num2) {

        if(num2 == 0) return;
        System.out.println(num1 * (num2 % 10));
        test(num1, num2 / 10);
    }
}
