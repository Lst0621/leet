// url: https://leetcode.com/problems/maximum-subarray/description/
package maxSub;

import java.util.ArrayList;
import java.util.Arrays;

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
	int max;

	public int maxSubArray(int[] nums) {

		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		max = nums[0];

		ArrayList<Integer> list = new ArrayList<>();
		list.add(Arrays.stream(nums).reduce((a, b) -> {
			max = Math.max(max, b);
			if (a * b > 0) {
				max = Math.max(max, a + b);
				return a + b;
			}
			list.add(a);
			max = Math.max(max, a);

			return b;

		}).getAsInt());
		if (list.size() == 0)
			return max;
		while(list.size()>0&&list.get(0) <= 0)
			list.remove(0);
		System.out.println(list);
		if (list.size() <= 1)
			return max;
		list.stream().reduce((a, b) -> {
			if (b > 0) {
				max = Math.max(max, a + b);
				return a + b;
			} else {
				if (-b > a) {
					max = Math.max(max, a);
					return 0;
				} else {
					max = Math.max(max, a + b);
					return a + b;
				}
			}

		}).get();
		return max;
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

		int[] tt = new int[] {-3,3,-2,3};
		System.out.println(maxSubArray(tt));
	}
}
