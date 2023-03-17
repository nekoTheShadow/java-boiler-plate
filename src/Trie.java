import java.util.HashMap;
import java.util.Map;

// トライ木(Trie木) https://algo-logic.info/trie-tree/
public class Trie {
    private Node root;
    
    public Trie() {
        this.root = new Node('\0');
    }
    
    // 文字列の挿入
    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.nexts.containsKey(c)) {
                cur = cur.nexts.get(c);
            } else {
                Node next = new Node(c);
                cur.nexts.put(c, next);
                cur = next;
            }
        }
        cur.accept = true;
    }
    
    // 文字列の検索 (完全一致)
    public boolean search(String word) {
        return search(word, false);
    }
    
    // 文字列の検索 (前方一致)
    public boolean startsWith(String prefix) {
        return search(prefix, true);
    }
    
    private boolean search(String word, boolean prefix) {
        Node cur = this.root;
        for (char c : word.toCharArray()) {
            if (!cur.nexts.containsKey(c)) {
                return false;
            }
            cur = cur.nexts.get(c);
        }
        return prefix || cur.accept;
    }
    
    public static class Node {
        public char c;
        public boolean accept;
        public Map<Character, Node> nexts;
        
        public Node(char c) {
            this.c = c;
            this.accept = false;
            this.nexts = new HashMap<>();
        }
    }
}
