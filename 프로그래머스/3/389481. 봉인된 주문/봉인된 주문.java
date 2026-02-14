import java.util.*;

class Solution {

    public String solution(long n, String[] bans) {

        HashSet<String> banSet = new HashSet<>();
        for (String b : bans) banSet.add(b);

        int B = banSet.size();
        long hi = n + B;

        long[] banRanks = new long[B];
        int idx = 0;
        for (String b : banSet) {
            banRanks[idx++] = toRankCapped(b, hi);
        }
        Arrays.sort(banRanks);

        long lo = 1;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long banned = countBanLeq(banRanks, mid);
            long alive = mid - banned;

            if (alive >= n) hi = mid;
            else lo = mid + 1;
        }

        return toAlpha(lo);
    }

    private long toRankCapped(String s, long cap) {
        long rank = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = (s.charAt(i) - 'a') + 1;

            if (rank > (cap - digit) / 26) {
                return cap + 1;
            }
            rank = rank * 26 + digit;
        }

        return rank;
    }

    private String toAlpha(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) ('a' + (n % 26)));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    private long countBanLeq(long[] arr, long x) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] <= x) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}