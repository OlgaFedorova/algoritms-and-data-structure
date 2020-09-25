package ofedorova.algoritms.on_stack.calculator;

import ofedorova.data_structures.stack.Stack;

public class InfixToPostfix {

  private Stack<Character> theStack;
  private String input;
  private String output;

  public InfixToPostfix(String input) {
    this.input = input;
    this.theStack = new Stack(input.length());
    this.output = "";
  }

  public String doTrans() {
    for (int j = 0; j < input.length(); j++) {
      char ch = input.charAt(j);
      switch (ch) {
        case '+':
        case '-':
          gotOperator(ch, 1);
          break;
        case '*':
        case '/':
          gotOperator(ch, 2);
          break;
        case '(':
          theStack.push(ch);
          break;
        case ')':
          gotBracket(ch);
          break;
        default:
          output = output + ch;
          break;
      }
    }

    while (!theStack.isEmpty()) {
      output = output + theStack.pop();
    }
    return output;
  }

  private void gotOperator(char opThis, int prec1) {
    while (!theStack.isEmpty()) {
      char opTop = theStack.pop();
      if (opTop == '(') {
        theStack.push(opTop);
        break;
      } else {
        int prec2 = opTop == '+' || opTop == '-' ? 1 : 2;
        if (prec2 < prec1) {
          theStack.push(opTop);
          break;
        } else {
          output = output + opTop;
        }
      }
    }
    theStack.push(opThis);
  }

  public void gotBracket(char ch) {
    while (!theStack.isEmpty()) {
      char chx = theStack.pop();
      if (chx == '(') {
        break;
      } else {
        output = output + chx;
      }
    }
  }
}
