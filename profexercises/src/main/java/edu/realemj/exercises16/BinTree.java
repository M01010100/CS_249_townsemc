package edu.realemj.exercises16;

public class BinTree <T extends Comparable<T>> {
    private BinNode<T> root = null;

    public void insert(T data) {
        BinNode<T> node = new BinNode<>(data);
        if(root == null) {
            root = node;
        }
        else {
            insertDown(node, root);
        }
    }

    private void insertDown(BinNode<T> newNode,
                            BinNode<T> current) {
        if(newNode.compareTo(current) < 0) {
            // LEFT
            if(current.getLeft() == null) {
                current.setLeft(newNode);
            }
            else {
                insertDown(newNode, current.getLeft());
            }
        }
        else {
            // RIGHT
            if(current.getRight() == null) {
                current.setRight(newNode);
            }
            else {
                insertDown(newNode, current.getRight());
            }
        }
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if(isEmpty()) {
            sb.append("Tree is empty.");
        }
        else {
            GenericQueue<BinNode<T>> q = new GenericQueue<>();
            q.enqueue(root);
            while(!q.isEmpty()) {
                var current = q.dequeue();
                sb.append(current.toString());
                sb.append(" ");

                if(current.getLeft() != null) {
                    q.enqueue(current.getLeft());
                }

                if(current.getRight() != null) {
                    q.enqueue(current.getRight());
                }
            }
        }

        return sb.toString();
    }
}
