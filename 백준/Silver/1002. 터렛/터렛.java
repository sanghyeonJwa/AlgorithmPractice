import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[][] circles = new int[num][6];
        int[] result = new int[num];


        for(int i = 0; i < num; i++) {
            for (int j = 0; j < 6; j++) {
                circles[i][j] = sc.nextInt();
            }

            double sumOfLength = (double)circles[i][2] + circles[i][5];
            double absOfLength = Math.abs(circles[i][2] - circles[i][5]);
            double distance = calculateDistance(circles[i][0], circles[i][1], circles[i][3], circles[i][4]);

            if (distance > sumOfLength || distance < absOfLength) {
                result[i] = 0;
            }
            // 1. 두 원이 완전히 겹치는 경우 (무한히 많은 교점)
            else if (distance == 0 && circles[i][2] == circles[i][5]) {
                result[i] = -1;
            }
            // 2. 외접 또는 내접하는 경우 (한 점에서 만남)
            else if (distance == sumOfLength || distance == absOfLength) {
                result[i] = 1;
            }
            // 3. 두 점에서 만나는 경우
            else {
                result[i] = 2;
            }
        }

        for(int answer : result) {
            System.out.println(answer);
        }
    }

    public static double calculateDistance(int x1, int y1, int x2, int y2) {

        // pow : 제곱하기 -> Math.pow(수, 제곱수)
        // sqrt : 제곱근 구하기
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
