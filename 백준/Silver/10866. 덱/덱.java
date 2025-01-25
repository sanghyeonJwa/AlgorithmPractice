

import java.util.*;
import java.io.*;

public class Main {
    
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String commandLine = br.readLine();
            String[] lines = commandLine.split(" ");

            switch (lines[0]) {
                case "push_front":
                    int xFront = Integer.parseInt(lines[1]);
                    pushFront(xFront);
                    break;

                case "push_back":
                    int xBack = Integer.parseInt(lines[1]);
                    pushBack(xBack);
                    break;

                case "pop_front":
                    popFront();
                    break;

                case "pop_back":
                    popBack();
                    break;

                case "size":
                    size();
                    break;

                case "empty":
                    empty();
                    break;

                case "front":
                    front();
                    break;

                case "back":
                    back();
                    break;
            }
        }
    }

    public static void pushFront(int x) {
        deque.addFirst(x);
    }

    public static void pushBack(int x) {
        deque.addLast(x);
    }

    public static void popFront() {
        if (deque.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(deque.pollFirst());
        }
    }

    public static void popBack() {
        if (deque.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(deque.pollLast());
        }
    }

    public static void size() {
        System.out.println(deque.size());
    }

    public static void empty() {
        if (deque.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void front() {
        if (deque.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(deque.peekFirst());
        }
    }

    public static void back() {
        if (deque.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(deque.peekLast());
        }
    }
}
