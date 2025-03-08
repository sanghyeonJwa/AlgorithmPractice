import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] bingoPlate = new int[5][5];
        Map<Integer, int[]> location = new HashMap<>();

        for(int i = 0; i < 5; i++){
            String[] bingoPlateInputs = br.readLine().split(" ");
            for(int j = 0; j < 5; j++){
                int num = Integer.parseInt(bingoPlateInputs[j]);
                bingoPlate[i][j] = num;
                location.put(num, new int[]{i, j});
            }
        }

        int cnt = 0;
        int[] rowCount = new int[5];
        int[] colCount = new int[5];
        int leftToRightCount = 0;
        int rightToLeftCount = 0;
        int bingoCnt = 0;

        for(int i = 0; i < 5; i++){
            String[] numbersInputs = br.readLine().split(" ");

            if(bingoCnt >= 3)
                continue;

            for(int j = 0; j < 5; j++){
                cnt++;
                int calledNumber = Integer.parseInt(numbersInputs[j]);

                int[] position = location.get(calledNumber);
                int row = position[0];
                int col = position[1];

                bingoPlate[row][col] = 0;

                if(++rowCount[row] == 5) bingoCnt++;
                if(++colCount[col] == 5) bingoCnt++;

                if(row == col && ++leftToRightCount == 5) bingoCnt++;
                if(row + col == 4 && ++rightToLeftCount == 5) bingoCnt++;

                if(bingoCnt >= 3) {
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
