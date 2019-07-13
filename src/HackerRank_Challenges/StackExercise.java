package HackerRank_Challenges;

import java.util.*;

/*
 Goal --> To know if a String of parenthesis is imbalanced.
          ()[] true
          [)] false
          [] true
          "" empty string true
 */

public class StackExercise {

    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stackParenthesis = new Stack<>();
        boolean isBalanced = false;

        while (sc.hasNextLine()) {

            String input = sc.next();
            for (int i = 0; i < input.length() ; i++) {

                if (stackParenthesis.isEmpty() ||
                        (((int) input.charAt(i)) != stackParenthesis.peek() + 1 ) &&
                        (((int) input.charAt(i)) != stackParenthesis.peek() + 2)) {
                    stackParenthesis.push(input.charAt(i));
                } else {
                    stackParenthesis.pop();
                }
            }

            if (stackParenthesis.isEmpty()){
                isBalanced = true;
            }

            System.out.println(isBalanced);
            isBalanced = false;
            stackParenthesis.clear();

        }
        sc.close();

    }

}


