// url: https://leetcode.com/problems/trapping-rain-water/description/
package trapH2O;
public class Solution {

	/** Ctrl + C starts here **/
	public int trap(int[] height) {
		int len = height.length;
		if (len <= 2)
			return 0;
		int head = height[0];
		int index = 0;
		int pool = 0;
		int sum = 0;
		for (int i = 1; i < len; i++) {
			int num = height[i];
			int diff = head - num;
			if (diff > 0) {
				pool += diff;
			} else {
				sum += pool;
				pool = 0;
				head = num;
				index = i;
			}
		}

		int tail = height[len - 1];
		pool = 0;
		for (int i = len - 2; i >= index; i--) {
			int num = height[i];
			int diff = tail - num;
			if (diff > 0) {
				pool += diff;
			} else {
				sum += pool;
				pool = 0;
				tail = num;
			}
		}

		return sum;
	}

	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		int[] rec = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		// should be 6
		System.out.println(trap(rec));
	}
}
