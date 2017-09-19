// url: https://leetcode.com/problems/output-contest-matches/description/
package contest;
import java.util.*;
public class Solution {

	/** Ctrl + C starts here **/
	public String findContestMatch(int n) {
		String s = "(1,2)";
		int cnt = 2;
		while (cnt < n) {
			StringBuilder sb = new StringBuilder();
			cnt *= 2;
			int num = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c >= '0' && c <= '9') {
					num = num * 10 + c - '0';
				} else {
					if (num != 0) {
						sb.append('(');
						sb.append(num);
						sb.append(',');
						sb.append(cnt + 1 - num);
						sb.append(')');
					}
					num = 0;
					sb.append(c);
				}
			}

			s = sb.toString();
		}
		return s;
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
		System.out.println(findContestMatch(32));
		System.out.println(findContestMatch(128));
	}
}
