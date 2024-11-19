import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while ((input = br.readLine()) != null) {
                String[] numbers = input.split(" ");
                int sum = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
                System.out.println(sum);
            }
        }
    }
}
