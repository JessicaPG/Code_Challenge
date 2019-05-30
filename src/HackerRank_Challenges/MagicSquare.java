package HackerRank_Challenges;
import java.io.*;

/*
    This is the proposed solution to compute the minCost of transform an input matrix of 3x3 into a MagicSquare (HackerRank platform)
    https://en.wikipedia.org/wiki/Magic_square
 */



public class MagicSquare {

    // Store all the possible permutations of 3x3 Magic Square
    private static int [][][] perm =  {{{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                                        {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
                                        {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                                        {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                                        {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                                        {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                                        {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                                        {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}}};





    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int minCost = 100;
        int tempMax = 0;


        //Compare the minCost between s and all matrix in perm
        for (int matrix = 0; matrix < perm.length ; matrix++) {
            tempMax = 0;
            for (int r = 0; r < perm[matrix].length; r++) {
                for (int elem = 0; elem < perm[matrix][r].length; elem++) {
                    tempMax +=  Math.abs(perm[matrix][r][elem] - s[r][elem]);

                }

            }
            if (tempMax < minCost) {
                minCost = tempMax;
            }
        }




        return minCost;

    }

    public static void main(String[] args) throws IOException {

        int[][] s ={{5,3,4},
                    {1,5,8},
                    {6,4,2}};


        int[][] b ={{4,5,8},
                    {2,4,1},
                    {1,9,7}};

        formingMagicSquare(b);
    }


}
