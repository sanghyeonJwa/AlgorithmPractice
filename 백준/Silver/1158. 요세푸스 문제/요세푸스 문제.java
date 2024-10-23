import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /**
         * 요세푸스 문제
         * Queue를 이요하여 풀 수 있다.
         * k - 1 번째까지의 사람을 뒤로 옮기고, k번째 사람을 poll 시키면서 result에 저장한다.
         */

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> man = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            man.add(i);
        }

        while(!man.isEmpty()) {
            for(int i = 0; i < k - 1; i++) {
                man.add(man.poll());
            }
            result.add(man.poll());
        }

        System.out.print("<");
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i) + ", ");
            }
        }
        System.out.println(">");
    }
}
