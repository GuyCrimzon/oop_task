import tree.MyTree;

public class Main {
    public static void main(String[] args) {
        MyTree trie = new MyTree();
        trie.put("abc");
        trie.put("aBC");


        System.out.println(trie.contains("abc"));
        System.out.println(trie.contains("aBC"));
        System.out.println(trie.contains("ab"));

        System.out.println(trie.remove("aBC"));
        System.out.println(trie.contains("abc"));
        System.out.println(trie.contains("aBC"));
    }
}
