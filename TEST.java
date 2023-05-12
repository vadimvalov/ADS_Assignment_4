public class TEST {

    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<Integer, String>();

        // Test put()
        tree.put(3, "three");
        tree.put(1, "one");
        tree.put(2, "two");
        tree.put(4, "four");

        System.out.println("_______________");

        // Test get()
        System.out.println(tree.get(1));
        System.out.println(tree.get(2));
        System.out.println(tree.get(3));
        System.out.println(tree.get(4)); 

        System.out.println("_______________");

        // Test delete()
        tree.delete(1);
        System.out.println(tree.get(1)); 
        System.out.println(tree.get(2)); 

        System.out.println("_______________");

        // Test iterator()
        for (int key : tree) {
            String val = tree.get(key);
            System.out.println("key is " + key + " and value is " + val);
        }
    }
}
