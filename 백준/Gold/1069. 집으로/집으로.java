import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        double X = Double.parseDouble(input[0]); // 현재 x
        double Y = Double.parseDouble(input[1]); // 현재 y
        double D = Double.parseDouble(input[2]); // 점프 시 움직이는 거리
        double T = Double.parseDouble(input[3]); // 점프 시 걸리는 시간

        double distance = Math.sqrt(X * X + Y * Y);

        double result = distance;

        // 점프 효율이 안나오는 경우 (= 걷는것과 동일한 경우)
        if(D <= T) {
            System.out.println(distance);
        }
        else if(D <= distance) {
            int jump = (int) (distance / D);
            result = Math.min(result, (T * jump) + (distance - D * jump));
            result = Math.min(result, T * (jump + 1));
        }
        else {
            result = Math.min(result, T + (D - distance));
            result = Math.min(result, T * 2);
        }
        
        System.out.println(result);
    }
}
