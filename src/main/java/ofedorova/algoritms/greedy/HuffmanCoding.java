package ofedorova.algoritms.greedy;

/**
 * Кодирование Хаффмана
 *
 *
 * По данной непустой строке s длины не более 10^4, состоящей из строчных букв латинского алфавита,
 * постройте оптимальный беспрефиксный код. В первой строке выведите количество различных букв k,
 * встречающихся в строке, и размер получившейся закодированной строки. В следующих k строках запишите коды
 * букв в формате "letter: code". В последней строке выведите закодированную строку.
 *
 * __________________________________
 * Sample Input 1:
 *
 * a
 *
 * Sample Output 1:
 *
 * 1 1
 * a: 0
 * 0
 * __________________________________
 * Sample Input 2:
 *
 * abacabad
 *
 * Sample Output 2:
 *
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 */
public class HuffmanCoding {

    abstract static class Node implements Comparable<Node> {
        private final int sum;
        private String code;

        protected Node(int sum) {
            this.sum = sum;
        }

        public void buildCode(String code){
            this.code = code;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }
    }

    static class InternalNode extends Node {
        private final Node left;
        private final Node right;

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }

        @Override
        public void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    static class LeafNode extends Node {
        private final char symbol;

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }

    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.next();

        java.util.Map<Character, Integer> countByChars = countByChars(input);
        java.util.Map<Character, Node> charsByCodes = new java.util.HashMap<>();
        Node charsTree = buildTree(countByChars, charsByCodes);
        fillSymbol(charsTree);
        String codingString = codingString(input, charsByCodes);

        System.out.println(countByChars.size() + " " + codingString.length());
        for (java.util.Map.Entry<Character, Node> characterWithCode: charsByCodes.entrySet()){
            System.out.println(characterWithCode.getKey() + ": " + characterWithCode.getValue().code);
        }
        System.out.println(codingString);
    }

    private static java.util.Map<Character, Integer> countByChars(String input) {
        java.util.Map<Character, Integer> countByChars = new java.util.HashMap<>();
        for (char ch: input.toCharArray()){
            if (countByChars.containsKey(ch)){
                countByChars.put(ch, countByChars.get(ch) + 1);
            } else {
                countByChars.put(ch, 1);
            }
        }
        return countByChars;
    }

    private static Node buildTree(java.util.Map<Character, Integer> countByChars,
                                  java.util.Map<Character, Node> charsByCodes){
        java.util.PriorityQueue<Node> charsByPriority = new java.util.PriorityQueue<>();
        for (java.util.Map.Entry<Character, Integer> characterWithCount: countByChars.entrySet()){
            LeafNode leafNode = new LeafNode(characterWithCount.getKey(), characterWithCount.getValue());
            charsByPriority.add(leafNode);
            charsByCodes.put(characterWithCount.getKey(), leafNode);
        }
        while (charsByPriority.size() > 1){
            Node first = charsByPriority.poll();
            Node second = charsByPriority.poll();
            InternalNode internalNode = new InternalNode(first, second);
            charsByPriority.add(internalNode);
        }
        return charsByPriority.poll();
    }

    private static void fillSymbol(Node charsTree){
        if (charsTree instanceof LeafNode) {
            charsTree.buildCode("0");
        } else {
            charsTree.buildCode("");
        }
    }

    private static String codingString(String input, java.util.Map<Character, Node> charsByCodes){
        StringBuilder codingInput = new StringBuilder();
        for (char ch: input.toCharArray()){
            codingInput.append(charsByCodes.get(ch).code);
        }
        return codingInput.toString();
    }
}
