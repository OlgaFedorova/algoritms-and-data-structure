package data_structures.stack;

public class StackApp {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);
        stack.push(10);
        stack.push(20);
        stack.push(5);
        stack.push(6);
        stack.push(66);
        stack.push(55);
        stack.push(44);
        stack.push(33);
        stack.push(77);
        stack.push(21);
        stack.push(23);
        stack.push(11);
        stack.push(45);

        while (!stack.isEmpty()) {
            int value = stack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
    }
}
