package algoritms.on_stack.reverse_string;

import data_structures.stack.Stack;

public class Reverser {

    private final String input;
    private String output;

    public Reverser(String in) {
        input = in;
    }

    public String reverse() {
        int stackSize = input.length();
        Stack<Character> theStack = new Stack(stackSize);
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.push(ch);
        }
        output = "";
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();
            output = output + ch;
        }
        return output;
    }
}
