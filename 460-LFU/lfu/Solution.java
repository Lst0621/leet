// url: https://leetcode.com/problems/lfu-cache/description/
package lfu;
import java.util.*;

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

class LFUCache {
	class Node {
		int freq;
		LinkedHashSet<Integer> set;
		Node prev, next;
		Node() {
			freq = 0;
			set = new LinkedHashSet<>();
			prev = null;
			next = null;
		}
		void dis() {
			prev.next = next;
			next.prev = prev;
		}
	}
	int cap, cnt;
	Map<Integer, Integer> kv;
	Map<Integer, Node> dic;
	Node head, tail;

	private void connect(Node a, Node b) {
		a.next = b;
		b.prev = a;
	}

	public LFUCache(int capacity) {
		this.cap = capacity;
		cnt = 0;
		kv = new HashMap<>();
		dic = new HashMap<>();
		head = new Node();
		tail = new Node();
		connect(head, tail);
	}

	private void addFreq(int key) {
		Node n = dic.get(key);
		int freq = n.freq;
		if (n.prev.freq != freq + 1) {
			Node m = new Node();
			m.freq = freq + 1;
			connect(n.prev, m);
			connect(m, n);
		}
		n.prev.set.add(key);
		n.set.remove(key);
		dic.put(key, n.prev);
		if (n.set.size() == 0)
			n.dis();
	}

	public int get(int key) {
		if (cap <= 0)
			return -1;
		if (kv.containsKey(key) == false) {
			return -1;
		}
		int ret = kv.get(key);
		addFreq(key);
		return ret;
	}

	public void put(int key, int value) {
		if (cap <= 0)
			return;
		if (dic.containsKey(key)) {
			addFreq(key);
		} else {
			boolean flag = true;
			if (cnt < cap) {
				cnt++;
				flag = false;
			}
			// evict
			if (flag) {
				Node n = tail.prev;
				int away = n.set.iterator().next();
				n.set.remove(away);
				kv.remove(away);
				dic.remove(away);
				if (n.set.isEmpty())
					n.dis();
			}
			if (tail.prev.freq != 1) {
				Node n = new Node();
				n.freq = 1;
				connect(tail.prev, n);
				connect(n, tail);
			}
			tail.prev.set.add(key);
			dic.put(key, tail.prev);
		}
		kv.put(key, value);
	}
}
public class Solution {

	/** Ctrl + C starts here **/

	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		System.out.println("");
		LFUCache c = new LFUCache(2);
		c.put(1, 1);
		c.put(2, 2);
		c.get(1);
		c.put(3, 3);
		c.get(2);
		c.get(3);
		c.put(4, 4);
		c.get(1);
		c.get(3);
		c.get(4);
	}
}
