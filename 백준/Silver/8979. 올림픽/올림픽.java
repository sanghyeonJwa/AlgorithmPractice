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

            if (nation2.gold != nation1.gold)
                return nation2.gold - nation1.gold;
            if (nation2.silver != nation1.silver)
                return nation2.silver - nation1.silver;
            return nation2.bronze - nation1.bronze;
        });

        int rank = 1;
        
        NationMedal prev = nationMedals.get(0);

        if (prev.nationNumber == k) {
            System.out.println(rank);
            return;
        }

        for (int i = 1; i < nationMedals.size(); i++) {
            NationMedal curr = nationMedals.get(i);

            if (curr.gold != prev.gold || curr.silver != prev.silver || curr.bronze != prev.bronze) {
                rank = i + 1;
            }

            if (curr.nationNumber == k) {
                System.out.println(rank);
                return;
            }

            prev = curr;
        }
    }
}

