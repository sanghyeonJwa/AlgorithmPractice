import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        List<Integer> sum = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            sum.add(num1 + num2);
        }
        for(int i : sum) {
            System.out.println(i);
        }
    }
}
