// url: https://leetcode.com/problems/valid-parentheses/description/

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid
 but "(]" and "([)]" are not.


 */

public class Solution {
	public boolean isValid(String s) {
		if (s == null)
			return false;
		int len = s.length();
		if (len == 0)
			return false;
		if (len % 2 == 1)
			return false;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' | c == '[') {
				stack.push(c);
			} else {
				if (stack.empty())
					return false;
				char d = stack.pop();
				switch (c) {
				case ')':
					if (d != '(')
						return false;
					break;
				case ']':
					if (d != '[')
						return false;
					break;
				case '}':
					if (d != '{')
						return false;
					break;
				default:
					return false;
				}
			}
		}
		return stack.empty();
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		String s = "([)]";
		System.out.println(s + ": " + isValid(s));
	}
}