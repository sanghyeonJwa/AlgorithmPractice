import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int stairs = sc.nextInt();
        int[] points = new int[stairs];

        for (int i = 0; i < stairs; i++) {
            points[i] = sc.nextInt();
        }

        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[] points) {

        if(points.length == 0)
            return 0;
        if(points.length == 1)
            return points[0];
        if(points.length == 2)
            return points[0] + points[1];

        int[] dp = new int[points.length];
        dp[0] = points[0];
        dp[1] = points[0] + points[1];
        dp[2] = Math.max(points[0] + points[2], points[1] + points[2]);

        for (int i = 3; i < points.length; i++) {
            dp[i] = Math.max(dp[i - 2] + points[i], dp[i - 3] + points[i - 1] + points[i]);
        }

        return dp[dp.length - 1];
    }
}
