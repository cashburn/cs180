import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tree {
    public static void main(String[] args) throws FileNotFoundException {
        Tree t = new Tree();
        Scanner in = new Scanner(new File("dickens-tale-of-two-cities.txt"));
        
        // Read "words" from the input file; uses the Scanner class definition of word...
        while (in.hasNext()) {
            while (in.hasNext("\\w+"))
                t.add(in.next("\\w+"));
            if (in.hasNext())
                in.next();
        }
        t.print();
    }
    
    private static class Node {
        int count = 1;
        String value;
        Node left = null;
        Node right = null;
    }

    private Node root = null;

    // proxy add
    public void add(String value) {
        root = add(value, root);
    }

    private static Node add(String value, Node tree) {
        if (tree == null) { // basis case
            tree = new Node();
            tree.value = value;
        }
        // left recursive case
        else if (value.compareTo(tree.value) < 0)
            tree.left = add(value, tree.left);
        // right recursive case
        else if (value.compareTo(tree.value) > 0)
            tree.right = add(value, tree.right);
        else if (value.compareTo(tree.value) == 0)
            tree.count++;
        return tree;
    }

    // proxy print
    public void print() {
        print(root);
    }

    private static void print(Node tree) {
        if (tree != null) {
            print(tree.left);
            System.out.println(tree.value + " - " + tree.count);
            print(tree.right);
        }
    }
    
    public int size() {
        return size(root);
    }
    
    private int size(Node tree) {
        if (tree == null)
            return 0;
        else
            return 1 + size(tree.left) + size(tree.right);
    }
}