import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        double avg = 0;

        List<Integer> num = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            num.add(sc.nextInt());
        }

        Collections.sort(num);

        for(int i = 0; i < num.size(); i++) {
                avg += (double) num.get(i) / num.get(num.size() - 1) * 100;
        }

        System.out.println(avg / num.size());
    }
}
