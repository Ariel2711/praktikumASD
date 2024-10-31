package utpASD;

import java.util.Scanner;
import java.util.Stack;

class WordReducer {
    private String sentence;

    public WordReducer(String sentence) {
        this.sentence = sentence;
    }

    public int reduceWord() {
        String[] words = sentence.trim().split("\\s+");
        Stack<String> stack = new Stack<String>();

        for (String word : words) {
            if (!stack.isEmpty() && stack.peek().equalsIgnoreCase(word)) {
                stack.pop();
            } else {
                stack.push(word);
            }
        }

        return stack.size();
    }
}

public class App2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        WordReducer wordReducer = new WordReducer(input);
        System.out.println(wordReducer.reduceWord());

        scanner.close();
    }
}