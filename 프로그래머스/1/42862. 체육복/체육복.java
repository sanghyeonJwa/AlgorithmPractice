import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        for (int number : reserve) {
            reserveList.add(number);
        }

        for (int number : lost) {
            if (reserveList.contains(number)) {
                reserveList.remove(Integer.valueOf(number));
            } else {
                lostList.add(number);
            }
        }

        for (int r : reserveList) {
            if (lostList.contains(r - 1)) {
                lostList.remove(Integer.valueOf(r - 1));
            } else if (lostList.contains(r + 1)) {
                lostList.remove(Integer.valueOf(r + 1));
            }
        }

        return n - lostList.size();
    }
}
