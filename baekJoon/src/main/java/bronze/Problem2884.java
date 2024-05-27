package bronze;
import java.util.*;

public class Problem2884 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int minute = sc.nextInt();

        if(hour == 0 && minute < 45);

        hour = minute < 45 ? hour == 0 ? 23 : hour - 1 : hour;

        minute = minute >= 45 ? minute - 45 : 60 + minute - 45;

        System.out.print(hour + " " + minute);
    }
}
