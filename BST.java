import java.util.ArrayList;
import java.util.Iterator;

public class BST<K extends Comparable<K>, V> implements Iterable<K> {

    private Node root;

    // кжс должно быть паблик..
    private class Node {
        private K key;
        private V val;
        private Node left, right;
        // 1) Add size
        private int size;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.size = 1; 
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.size = 1 + size(x.left) + size(x.right); 
        return x;
    }

    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Iterator<K> iterator() {
        // 3) Make it possible to access both keys and values
        ArrayList<K> list = new ArrayList<K>();
        inorder(root, list);
        return list.iterator();
    }

    // 2) inorder() for iterator(). 
    private void inorder(Node x, ArrayList<K> list) {
        if (x == null) return;
        inorder(x.left, list);
        list.add(x.key);
        inorder(x.right, list);
    }

    // 1) Add size
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

}
