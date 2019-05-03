package training_Problems;

public class SolutionCountCounters {

    /**
     * From Codility lessons
     * You are given N counters, initially set to 0, and you have two possible operations on them:
     *
     * increase(X) − counter X is increased by 1,
     * max counter − all counters are set to the maximum value of any counter.
     * A non-empty array A of M integers is given. This array represents consecutive operations:
     *
     * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
     * if A[K] = N + 1 then operation K is max counter.
     * For example, given integer N = 5 and array A such that:
     *
     *     A[0] = 3
     *     A[1] = 4
     *     A[2] = 4
     *     A[3] = 6
     *     A[4] = 1
     *     A[5] = 4
     *     A[6] = 4
     * the values of the counters after each consecutive operation will be:
     *
     *     (0, 0, 1, 0, 0)
     *     (0, 0, 1, 1, 0)
     *     (0, 0, 1, 2, 0)
     *     (2, 2, 2, 2, 2)
     *     (3, 2, 2, 2, 2)
     *     (3, 2, 2, 3, 2)
     *     (3, 2, 2, 4, 2)
     *
     * Expected Output =  (3, 2, 2, 4, 2)
     * ---------------------
     * Scores = 100%
     * Complexity O(N + M)
     *
     */



    public static int[] solutionCounters(int N, int[] A) {

        int[] result = new int[N];
        int max = 0;
        int maxToRefill = 0;
        boolean refill = false;

        for (int elem : A) {

            if (elem >= 1 && elem <= N) {
                int currentValue;

                if (refill) {
                    currentValue = result[elem - 1] <= maxToRefill ? maxToRefill + 1 : result[elem - 1] + 1;
                } else {
                    currentValue = result[elem - 1] + 1;
                }

                result[elem - 1] = currentValue;

                if (result[elem - 1] > max) {
                    max = result[elem - 1];
                }

            } else if (elem == N + 1) {
                refill = true;
                maxToRefill = max;
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] < maxToRefill) {
                result[i] = maxToRefill;
            }
        }

        return result;
    }
}
