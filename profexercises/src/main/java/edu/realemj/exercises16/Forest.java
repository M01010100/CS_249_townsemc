package edu.realemj.exercises16;

public class Forest {
    public static void main(String [] args) {
        BinTree<Integer> tree = new BinTree<>();
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(10);
        tree.insert(3);
        tree.insert(1);
        tree.insert(7);
        System.out.println(tree);
    }
}
