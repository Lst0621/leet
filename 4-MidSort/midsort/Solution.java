// url: https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/
package midsort;

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
	public double findMedianSortedArrays(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		int k1 = (m + n + 2) / 2;
		int k2 = (m + n + 1) / 2;
		if (k1 == k2)
			return helper(a, 0, b, 0, k1);
		else
			return (helper(a, 0, b, 0, k1) + helper(a, 0, b, 0, k2)) / 2;
	}

	private double helper(int[] a, int pa, int[] b, int pb, int k) {
		if (pa > a.length - 1)
			return b[pb + k - 1];
		if (pb > b.length - 1)
			return a[pa + k - 1];
		if (k == 1)
			return Math.min(a[pa], b[pb]);
		int aMid =
		    pa + k / 2 - 1 < a.length ? a[pa + k / 2 - 1] : Integer.MAX_VALUE;
		int bMid =
		    pb + k / 2 - 1 < b.length ? b[pb + k / 2 - 1] : Integer.MAX_VALUE;
		if (aMid < bMid)
			return helper(a, pa + k / 2, b, pb, k - k / 2);
		else
			return helper(a, pa, b, pb + k / 2, k - k / 2);
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
		//		int[] a = new int[]{1,2,3,5,67,113};
		//		int[] b = new int[]{4,12,13,18};
		int[] a = new int[] {1, 2};
		int[] b = new int[] {3, 4};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(findMedianSortedArrays(a, b));
	}
}
