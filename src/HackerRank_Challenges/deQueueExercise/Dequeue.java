package HackerRank_Challenges.deQueueExercise;

import java.util.*;
import java.util.stream.Collectors;

public class Dequeue {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        List<Integer> uniqueNum = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;

        int n = in.nextInt();
        int m = in.nextInt();


        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);
            if (map.get(num) != null) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

            if (i == m - 1) {
                uniqueNum = (List<Integer>) deque.stream()
                        .distinct().collect(Collectors.toList());

                max = uniqueNum.size();

            } else if (deque.size() > m) {
                Object numToRemove = deque.pop();
                map.put((int)numToRemove, map.get(numToRemove) - 1);

                if(map.get(numToRemove) == 0)
                    uniqueNum.remove(numToRemove);

                if(!uniqueNum.contains(num)){
                    uniqueNum.add(num);
                }
            }

            if (uniqueNum.size() > max){
                max = uniqueNum.size();
            }

            if (uniqueNum.size() == m) {
                break;
            }
        }

        in.close();
        System.out.println(max + "\n");
    }
}



