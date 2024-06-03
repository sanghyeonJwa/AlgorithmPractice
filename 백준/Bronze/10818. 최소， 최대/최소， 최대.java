import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            numbers.add(sc.nextInt());
        }

        Collections.sort(numbers);

        System.out.printf("%d %d", numbers.get(0), numbers.get(count - 1));
    }
}