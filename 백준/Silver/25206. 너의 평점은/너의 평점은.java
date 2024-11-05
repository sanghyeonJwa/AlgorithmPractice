import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        /**
         * S5 : 너의 평점은
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double totalPoint = 0.0;    // 전공평점 합
        double totalGrade = 0.0;    // 학점 합
        double avg = 0.0;
        String line;

        while((line = br.readLine()) != null) {

            String[] tokens = line.split(" ");

            double parsedGrade = Double.parseDouble(tokens[1]);
            double parsedPoint = changeGradeToPoint(tokens[2]);

            totalPoint += (parsedGrade * parsedPoint);
            if (!tokens[2].equals("P"))
                totalGrade += parsedGrade;
        }

        br.close();

        System.out.println(totalPoint / totalGrade);
    }

    static double changeGradeToPoint(String grade) {
        return switch (grade) {
            case "A+" -> 4.5;
            case "A0" -> 4.0;
            case "B+" -> 3.5;
            case "B0" -> 3.0;
            case "C+" -> 2.5;
            case "C0" -> 2.0;
            case "D+" -> 1.5;
            case "D0" -> 1.0;
            default -> 0.0;
        };
    }
}
