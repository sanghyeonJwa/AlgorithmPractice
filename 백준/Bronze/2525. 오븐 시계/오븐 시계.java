import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] time = br.readLine().split(" ");
        int cookingTime = Integer.parseInt(br.readLine());

        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        int cookingHour = cookingTime / 60;
        int cookingMinute = cookingTime % 60;

        int estimatedHour = hour + cookingHour;
        int estimatedMinute = (minute + cookingMinute) % 60;

        if(minute + cookingMinute >= 60)
            estimatedHour++;

        estimatedHour = estimatedHour % 24;

        String result = estimatedHour + " " + estimatedMinute;

        System.out.println(result);

        br.close();
    }
}
