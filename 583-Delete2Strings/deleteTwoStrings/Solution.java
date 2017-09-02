// url:
// https://leetcode.com/problems/delete-operation-for-two-strings/description/
package deleteTwoStrings;
public class Solution {

	/** Ctrl + C starts here **/
	public int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		return len1+ len2;
	}

	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		String a = "eat";
		String b = "sea";
		System.out.println(a);
		System.out.println(b);
		System.out.println(minDistance(a, b));
	}
}
