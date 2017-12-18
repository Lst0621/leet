// url: https://leetcode.com/problems/implement-trie-prefix-tree/description/
package impTrie;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃ 　
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃　　　　　　　　　　　
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + 　　　
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+　　　　　　　　　
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * */
class Node {
	private char c;
	private boolean isEnd;
	private Node[] array;
	public Node(char c) {
		this.c = c;
		isEnd = false;
		array = new Node[26];
	}
	public void insert(String word, int index) {
		if (index == word.length() - 1) {
			isEnd = true;
			return;
		}
		char ch = word.charAt(index + 1);
		if (array[ch - 'a'] == null)
			array[ch - 'a'] = new Node(ch);
		array[ch - 'a'].insert(word, index + 1);
	}

	public boolean search(String word, int index) {
		if (index == word.length() - 1) {
			return isEnd;
		}
		Node node = array[word.charAt(index + 1) - 'a'];
		if (node == null)
			return false;
		return node.search(word, index + 1);
	}

	public boolean startsWith(String word, int index) {
		if (index == word.length() - 1) {
			return true;
		}
		Node node = array[word.charAt(index + 1) - 'a'];
		if (node == null)
			return false;
		return node.startsWith(word, index + 1);
	}
}
class Trie {

	/** Initialize your data structure here. */
	private Node root;
	public Trie() { root = new Node(' '); }

	/** Inserts a word into the trie. */
	public void insert(String word) { root.insert(word, -1); }

	/** Returns if the word is in the trie. */
	public boolean search(String word) { return root.search(word, -1); }

	/** Returns if there is any word in the trie that starts with the given
	 * prefix. */
	public boolean startsWith(String prefix) {
		return root.startsWith(prefix, -1);
	}
}

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		Trie t = new Trie();
		t.insert("hello");
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		System.out.println("");
	}
}
