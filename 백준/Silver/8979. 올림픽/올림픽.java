import java.util.*;
import java.io.*;

public class Main {

    public static class NationMedal {

        int nationNumber;
        int gold;
        int silver;
        int bronze;

        public NationMedal(int nationNumber, int gold, int silver, int bronze) {

            this.nationNumber = nationNumber;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    static int n, k;
    static List<NationMedal> nationMedals = new ArrayList<>();
    static int goldGap, silverGap, bronzeGap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int gold, silver, bronze, nationNumber;

        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            nationNumber = Integer.parseInt(st.nextToken());
            gold = Integer.parseInt(st.nextToken());
            silver = Integer.parseInt(st.nextToken());
            bronze = Integer.parseInt(st.nextToken());

            nationMedals.add(new NationMedal(nationNumber, gold, silver, bronze));
        }

        nationMedals.sort((nation1, nation2) -> {

            goldGap = nation1.gold - nation2.gold;
            silverGap = nation1.silver - nation2.silver;
            bronzeGap = nation1.bronze - nation2.bronze;

            if(goldGap == 0) {
                if(silverGap == 0) {
                    return bronzeGap;
                }
                return silverGap;
            }

            return goldGap;
        });

        for(int i = 0; i < nationMedals.size(); i++) {
            if(nationMedals.get(i).nationNumber == k)
                System.out.println(i);
        }
    }
}

