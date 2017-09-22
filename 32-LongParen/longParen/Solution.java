//url: https://leetcode.com/problems/longest-valid-parentheses/description/
package longParen;


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

public class Solution {

	/** Ctrl + C starts here **/
	public int longestValidParentheses(String s) {

		String str = truncate(s);
		if(str==null) return 0;
		return helper(str);

	}

	private int helper(String s){
		int len = s.length();
		return 0;
	}

	private String truncate(String s){
		int len = s.length();
		int i,j;
		for(i=0;i<len;i++){
			if(s.charAt(i)=='(')
				break;
		}
		for(j=len-1;j>=0;j--){
			if(s.charAt(j)==')')
				break;
		}
		if(i==len||j==-1)
			return null;
		return s.substring(i,j);
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
		String str1 = ")))()()()()))))((((";
		System.out.println(str1);
		System.out.println(longestValidParentheses(str1));
	}
}
