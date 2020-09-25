package ofedorova.algoritms.on_stack.brackets;

import ofedorova.data_structures.stack.Stack;

public class Brackets {

    private String input;
    private static final char[] OPEN_BRACKETS = {'{', '(', '['};
    private static final char[] CLOSE_BRACKETS = {'}', ')', ']'};

    public Brackets(String input) {
        this.input = input;
    }

    public void check() {
        Stack<Character> theStack = new Stack<>(input.length());

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            if (contains(OPEN_BRACKETS, ch)) {
                theStack.push(ch);
            }

            if (contains(CLOSE_BRACKETS, ch)) {
                if (theStack.isEmpty() || !checkPair(theStack.pop(), ch)) {
                    System.out.println("Error: " + ch + " at " + j);
                    break;
                }
            }
        }

        if (!theStack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        } else {
            System.out.println("Correct string!");
        }
    }

    private boolean contains(char[] arr, char ch) {
        for (char el : arr) {
            if (el == ch) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPair(char first, char second) {
        for (int i = 0; i < OPEN_BRACKETS.length; i++) {
            if (OPEN_BRACKETS[i] == first && CLOSE_BRACKETS[i] == second) {
                return true;
            }
        }
        return false;
    }
}
