import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie<T> {
	private Node<T> root;
	
	public Trie() {
		this.root = new Node<T>();
	}
	
	public void insert(String key, T value) {
		Node<T> node = root;
		for (char ch : key.toCharArray()) {
			if (!node.children.containsKey(ch)) {
				node.children.put(ch, new Node<T>());
			}
			node = node.children.get(ch);
		}
		node.value = value;
	}
	
	// trieに登録されている文字をsとする
	// key.start_with(s)を満たす、すべてのvalueを返す
	public List<T> query(String key) {
		List<T> values = new ArrayList<>();
		Node<T> node = root;
		for (char ch : key.toCharArray()) {
			if (node.value != null) {
				values.add(node.value);
			}
			if (!node.children.containsKey(ch)) {
				break;
			}
			node = node.children.get(ch);
		}
		return values;
	}
	
	private static class Node<T> {
		private Map<Character, Node<T>> children;
		private T value;
		
		public Node() {
			this.children = new HashMap<>();
			this.value = null;
		}
	}
}
