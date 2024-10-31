package InfixBinaryTree;

import java.util.Stack;
import java.util.Scanner;

class Node {
    String value;
    Node left, right;

    Node(String item) {
        value = item;
        left = right = null;
    }
}

class ExpressionTree {

    boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    Node buildTree(String[] infix) {
        Stack<Node> operandStack = new Stack<Node>();
        Stack<String> operatorStack = new Stack<String>();
        int i = 0;
        System.out.println(i++);
        System.out.println(++i);

        for (String token : infix) {
            if (!isOperator(token) && !token.equals("(") && !token.equals(")")) {
                operandStack.push(new Node(token));
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    Node node = new Node(operatorStack.pop());
                    node.right = operandStack.pop();
                    node.left = operandStack.pop();
                    operandStack.push(node);
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && precedence(token) <= precedence(operatorStack.peek())) {
                    Node node = new Node(operatorStack.pop());
                    node.right = operandStack.pop();
                    node.left = operandStack.pop();
                    operandStack.push(node);
                }
                operatorStack.push(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            Node node = new Node(operatorStack.pop());
            node.right = operandStack.pop();
            node.left = operandStack.pop();
            operandStack.push(node);
        }

        return operandStack.pop();
    }

    int precedence(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return 0;
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + " ");
        }
    }
}

public class InfixToBinaryTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpressionTree tree = new ExpressionTree();

        String input = scanner.nextLine();

        String[] tokens = input.replaceAll("[()]", " $0 ").trim().split("\\s+");

        Node root = tree.buildTree(tokens);

        System.out.print("Preorder  : ");
        tree.preorder(root);
        System.out.println();

        System.out.print("Inorder   : ");
        tree.inorder(root);
        System.out.println();

        System.out.print("Postorder : ");
        tree.postorder(root);
        System.out.println();

        scanner.close();
    }
}
