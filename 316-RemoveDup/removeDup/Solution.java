// url: https://leetcode.com/problems/remove-duplicate-letters/description/
package removeDup;

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

// fixme
public class Solution {

	/** Ctrl + C starts here **/

	public String removeDuplicateLetters(String s) {
		List<Integer>[] arrays = new List[26];
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'a';
			if (arrays[c] == null) {
				cnt++;
				arrays[c] = new LinkedList<>();
			}
			arrays[c].add(i);
		}

		StringBuilder sb = new StringBuilder();
		while (cnt > 0) {
			int i = 0;
			int pos = -1;
			for (; i < 26; i++) {
				if (arrays[i] == null)
					continue;
				pos = arrays[i].get(0);
				boolean good = true;
				for (int j = 0; j < 26; j++) {
					if (i == j)
						continue;
					if (arrays[j] == null)
						continue;
					List<Integer> list = arrays[j];
					if (pos > list.get(list.size() - 1)) {
						good = false;
						break;
					}
				}
				if (good) {
					break;
				}
			}
			cnt--;
			sb.append((char)(i + 'a'));
			arrays[i] = null;
			for (int j = 0; j < 26; j++) {
				if (arrays[j] == null)
					continue;
				List<Integer> list = arrays[j];
				while (list.size() > 0 && list.get(0) < pos) {
					list.remove(0);
				}
				if (list.size() == 0)
					arrays[j] = null;
			}
		}
		return sb.toString();
	}

	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		System.out.println("");
		String a = "cbacdcbc";
		System.out.println(a);
		System.out.println(removeDuplicateLetters(a));
	}
}
