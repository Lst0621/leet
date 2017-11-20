// url:
// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
package longestStrTwoDistChar;
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
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null)
			return 0;
		int len = s.length();
		if (len <= 2)
			return len;

		int start = 0;
		int end = 1;
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < 26; i++)
			map.put((char)('a' + i), 0);

		for (int i = 0; i < 26; i++)
			map.put((char)('A' + i), 0);

		int ret = 0;

		int cnt = 1;
		char c = s.charAt(0);
		map.put(c, 1);
		for (; end < len; end++) {
			c = s.charAt(end);
			int times = map.get(c);
			if (times > 0) {
				map.put(c, times + 1);
			} else {
				map.put(c, 1);
				cnt++;
				while (cnt > 2) {
					char head = s.charAt(start);
					times = map.get(head);
					times--;
					map.put(head, times);
					if (times == 0)
						cnt--;
					start++;
				}
			}
			ret = Math.max(ret, end - start + 1);
			System.out.println(start + " " + end + " " + ret);
		}
		return ret;
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
		String s = "ececdkfjkeje";

		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}
}
