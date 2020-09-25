package ofedorova.algoritms.on_stack.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixApp {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    while (true) {
      System.out.println("Enter infix: ");
      input = br.readLine();
      if (input.equals("")) {
        break;
      }

      InfixToPostfix theTrans = new InfixToPostfix(input);
      System.out.println("Postfix is " + theTrans.doTrans());
    }
  }

}
