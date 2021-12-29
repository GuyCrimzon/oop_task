package tree;

import java.util.Map;
import java.util.TreeMap;

public class MyTree {

    private class MyTreeNode {
        Map<Character, MyTreeNode> children = new TreeMap<>();
        boolean key;
    }

    private MyTreeNode root = new MyTreeNode();


    public void put(String s) throws NullPointerException {
        try {
            MyTreeNode curr = root;
            for (char ch : s.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    curr.children.put(ch, new MyTreeNode());
                }
                curr = curr.children.get(ch);
            }
            curr.key = true;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    public boolean contains(String s) throws NullPointerException {
        try {
            MyTreeNode curr = root;
            for (char ch : s.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    return false;
                } else {
                    curr = curr.children.get(ch);
                }
            }
            return curr.key;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remove(String s) throws NullPointerException {
        try {
            MyTreeNode curr = root;
            return remove(s.toCharArray(), 0, curr);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean remove(char[] s, int index, MyTreeNode curr) {
        boolean check = index == s.length;
        if (!check) {
            char ch = s[index];
            if (curr.children.containsKey(ch)) {
                check = remove(s, index + 1, curr.children.get(ch));
            }
            if (check) {
                if (curr.children.get(ch).children.size() == 0) {
                    curr.children.remove(ch);
                }
            }
        } else {
            check = curr.key;
        }
        return check;
    }
}
