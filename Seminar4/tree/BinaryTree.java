package Seminar4.tree;



public class BinaryTree<V extends Comparable<V>> {

    private Node root;

    public class Node {
        private V data;
        private Node leftChild;
        private Node rightChild;
    }

    public boolean findNode(V data) {
        Node node = root;
        while (node != null) {
            if (node.data.equals(data)) {
                return true;
            }
            if (node.data.compareTo(data) > 0) {
                node = node.leftChild;
            }else {
                node = node.rightChild;
            }
        }
        return false; 
    }



}
