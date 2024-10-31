package binarySearchTree;

import java.util.*;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        right = null;
        left = null;
    }
}

class Tree {
    Node root;

    void add(int data) {
        root = addRecursive(data, root);
    }

    private Node addRecursive(int data, Node current) {
        if (current == null) {
            return new Node(data);
        } else {
            if (data > current.data) {
                current.right = addRecursive(data, current.right);
            } else if (data < current.data) {
                current.left = addRecursive(data, current.left);
            } else {
                return current;
            }
        }
        return current;
    }

    boolean search(int parent, int child) {
        Node parentNode = search_Recursive(root, parent);
        if (parentNode == null) {
            System.out.println(child + " bukan keturunan dari " + parent);
            return false;
        } else if (parent == child) {
            System.out.println(child + " bukan keturunan dari " + parent);
            return false;
        } else if (search_Recursive(parentNode, child) != null) {
            System.out.println(child + " merupakan keturunan dari " + parent);
            return true;
        } else {
            System.out.println(child + " bukan keturunan dari " + parent);
            return false;
        }
    }

    private Node search_Recursive(Node current, int key) {

        if (current == null || current.data == key)
            return current;

        if (key < current.data)
            return search_Recursive(current.left, key);

        return search_Recursive(current.right, key);
    }

    void delete(int start, int end) {
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        for (int i = start; i <= end; i++) {
            root = deleteRecursive(root, i);
        }
    }

    private Node deleteRecursive(Node current, int key) {
        if (current == null) {
            return current;
        }

        if (key < current.data) {
            current.left = deleteRecursive(current.left, key);
        } else if (key > current.data) {
            current.right = deleteRecursive(current.right, key);
        } else {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }
            current.data = minValue(current.right);
            current.right = deleteRecursive(current.right, current.data);
        }

        return current;
    }

    private int minValue(Node node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    void inorder() {
        inorderRecursive(root);
        System.out.println("");
    }

    private void inorderRecursive(Node current) {
        if (current != null) {
            inorderRecursive(current.left);
            System.out.print(current.data + " ");
            inorderRecursive(current.right);
        }
    }

}

public class Solution {
    public static void main(String[] args) {
        Tree keluarga = new Tree();
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        for (String data : arr) {
            keluarga.add(Integer.parseInt(data));
        }

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String action = scanner.nextLine();
            String[] actionList = action.split(" ");

            switch (actionList[0]) {
                case "search" -> {
                    keluarga.search(Integer.parseInt(actionList[1]), Integer.parseInt(actionList[2]));
                }
                case "delete" -> {
                    keluarga.delete(Integer.parseInt(actionList[1]), Integer.parseInt(actionList[2]));
                }
            }
        }
        keluarga.inorder();

        scanner.close();
    }
}