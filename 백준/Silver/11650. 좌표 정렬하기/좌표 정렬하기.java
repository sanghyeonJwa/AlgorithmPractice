import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Point> points = new ArrayList<>();
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            int xPoint = sc.nextInt();
            int yPoint = sc.nextInt();
            points.add(new Point(xPoint, yPoint));
        }

        Collections.sort(points);

        for(Point p : points) {
            System.out.println(p.x + " " + p.y);
        }
    }

    static class Point implements Comparable<Point> {

        int x, y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.x == other.x) {
                return Integer.compare(this.y, other.y);
            }
            return Integer.compare(this.x, other.x);
        }
    }
}
