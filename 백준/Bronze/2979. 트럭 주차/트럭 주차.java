import java.util.*;
import java.io.*;

public class Main {

    public static class Car {
        int start, end;

        Car(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] charges = br.readLine().split(" ");

        int chargeA = Integer.parseInt(charges[0]);
        int chargeB = Integer.parseInt(charges[1]);
        int chargeC = Integer.parseInt(charges[2]);

        for(int i = 0; i < 3; i++) {
            String[] carInput = br.readLine().split(" ");
            cars.add(new Car(Integer.parseInt(carInput[0]), Integer.parseInt(carInput[1])));
        }

        System.out.println(checkCosts(chargeA, chargeB, chargeC));
    }

    public static int checkCosts(int chargeA, int chargeB, int chargeC) {

        int totalCost = 0;
        int[] times = new int[101];

        for(Car car : cars) {
            for(int i = car.start; i < car.end; i++) {
                times[i]++;
            }
        }

        for(int i = 0; i < times.length; i++) {
            totalCost += times[i] == 0 ? 0 : times[i] == 1 ? chargeA : times[i] == 2 ? chargeB * 2 : chargeC * 3;
        }

        return totalCost;
    }
}
