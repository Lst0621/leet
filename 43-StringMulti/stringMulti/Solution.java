// url: https://leetcode.com/problems/multiply-strings/description/
package stringMulti;
public class Solution {

	/** Ctrl + C starts here **/
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		if (num1.equals("1"))
			return num2;
		if (num1.equals("1"))
			return num1;

		int l1 = num1.length();
		int l2 = num2.length();
		int[] numa = strToArray(num1);
		int[] numb = strToArray(num2);
		int[] res = new int[l1 + l2];

		int carry = 0;
		for (int i = 0; i < l1; i++) {
			carry = 0;
			int j = 0;
			for (; j < l2; j++) {
				int temp = numa[i] * numb[j] + carry + res[i + j];
				carry = temp / 10;
				res[i + j] = temp % 10;
			}
			res[i + j] = carry;
		}

		StringBuilder sb = new StringBuilder();

		if (carry > 0)
			sb.append(carry);

		for (int i = l1 + l2 - 2; i >= 0; i--) {
			sb.append(res[i]);
		}

		return sb.toString();
	}

	private int[] strToArray(String str) {
		int len = str.length();
		int[] res = new int[len];
		for (int i = 0; i < len; i++)
			res[len - 1 - i] = str.charAt(i) - '0';
		return res;
	}

	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		String a = "1232131";
		String b = "1232131";
		System.out.println(a + "x" + b);
		System.out.println(multiply(a, b));
	}
}
