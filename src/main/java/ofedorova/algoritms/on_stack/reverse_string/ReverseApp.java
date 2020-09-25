package ofedorova.algoritms.on_stack.reverse_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseApp {

    public static void main(String[] args) throws IOException {
        String input, output;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Enter a string: ");
                input = reader.readLine();
                if (input.equals("")) {
                    break;
                }
                Reverser theReverser = new Reverser(input);
                output = theReverser.reverse();
                System.out.println("Reversed: " + output);
            }
        }
    }
}
