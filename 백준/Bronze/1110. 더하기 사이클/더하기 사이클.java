import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int initNum = sc.nextInt();
        if(initNum < 10) initNum *= 10;

        int num = initNum;

        while (true) {
            cnt++;
            int newNum = (num % 10) * 10 + (num % 10 + num / 10) % 10;

            if (newNum == initNum) {
                break;
            }

            num = newNum;
        }

        System.out.println(cnt);
    }
}
