import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int a = 'a'; // 97
        int z = 'z'; // 122

        List<Integer> numList = new ArrayList<>(Collections.nCopies(26, -1));

        for(int i = 0; i < str.length(); i++) {
            if(numList.get(str.charAt(i) - 'a') == -1) {
                numList.set(str.charAt(i) - 'a', (Integer) i);
            }
        }
        for(Integer i : numList) {
            System.out.print(i + " ");
        }
    }
}
