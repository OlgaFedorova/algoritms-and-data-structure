package ofedorova.algoritms.greedy;

/**
 * Декодирование Хаффмана
 *
 * Восстановите строку по её коду и беспрефиксному коду символов.
 * В первой строке входного файла заданы два целых числа k и l через пробел — количество различных букв,
 * встречающихся в строке, и размер получившейся закодированной строки, соответственно. В следующих k строках
 * записаны коды букв в формате "letter: code". Ни один код не является префиксом другого.
 * Буквы могут быть перечислены в любом порядке. В качестве букв могут встречаться лишь строчные буквы
 * латинского алфавита; каждая из этих букв встречается в строке хотя бы один раз.
 * Наконец, в последней строке записана закодированная строка.
 * Исходная строка и коды всех букв непусты.
 * Заданный код таков, что закодированная строка имеет минимальный возможный размер.
 * В первой строке выходного файла выведите строку s. Она должна состоять из строчных букв латинского алфавита.
 * Гарантируется, что длина правильного ответа не превосходит 10^4 символов.
 *
 * --------------------------------
 * Sample Input 1:
 *
 * 1 1
 * a: 0
 * 0
 * Sample Output 1:
 *
 * a
 * --------------------------------
 * Sample Input 2:
 *
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 * Sample Output 2:
 *
 * abacabad
 */
public class HuffmanDecoding {

    private static class Symbol {
        private final String symbol;
        private final String code;

        public Symbol(String symbol, String code) {
            this.symbol = symbol;
            this.code = code;
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int countOfSymbols = scanner.nextInt();
        int lengthOfCodingString = scanner.nextInt();

        Symbol[] symbols = new Symbol[countOfSymbols];
        java.util.regex.Pattern defaultDelimiter = scanner.delimiter();
        scanner.useDelimiter(System.lineSeparator());
        for (int i = 0; i < countOfSymbols; i++){
            String[] temp = scanner.next("[a-z]: [0-9]+").split(": ");
            symbols[i] = new Symbol(temp[0], temp[1]);
        }
        scanner.useDelimiter(defaultDelimiter);
        java.util.Arrays.sort(symbols, java.util.Comparator.comparing(s -> s.code));

        String coddingString = scanner.next();

        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < lengthOfCodingString){
            for (int i = 0; i < symbols.length; i++){
                int indexOf = coddingString.indexOf(symbols[i].code, index);
                if (indexOf == index) {
                    result.append(symbols[i].symbol);
                    index = indexOf + symbols[i].code.length();
                    break;
                }
            }
        }

        System.out.println(result.toString());
    }
}
