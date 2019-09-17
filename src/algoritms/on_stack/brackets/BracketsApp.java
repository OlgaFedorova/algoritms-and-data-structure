package algoritms.on_stack.brackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketsApp {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while (true) {
                System.out.println("Enter string containing delimiters: ");
                input = reader.readLine();
                if (input.equals("")) {
                    break;
                }
                Brackets theChecker = new Brackets(input);
                theChecker.check();
            }
        }
    }
}
