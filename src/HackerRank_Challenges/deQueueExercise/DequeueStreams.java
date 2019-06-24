package HackerRank_Challenges.deQueueExercise;


import java.util.*;
import java.util.concurrent.TimeUnit;

public class DequeueStreams {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int maxTemp = 0;
        int max = 0;

        int n = in.nextInt();
        int m = in.nextInt();


        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);

            if (i == m - 1) {
                maxTemp = (int) deque.stream()
                        .distinct().count();
            } else if (deque.size() > m) {
                deque.pop();
                maxTemp = (int) deque.stream()
                        .distinct().count();

            }

            if (maxTemp > max) {
                max = maxTemp;
            }

            if (max == m) {
                break;

            }

        }
        long duration =  TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime);

        in.close();
        System.out.println(max);
        System.out.println(duration);
    }
}



