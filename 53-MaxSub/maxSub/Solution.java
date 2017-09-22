// url: https://leetcode.com/problems/maximum-subarray/description/
package maxSub;

import java.util.ArrayList;
import java.util.List;

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
		int len = nums.length;
		if (len == 1)
			return nums[0];
		List<Integer> list = new ArrayList<>(len);
		int n = nums[0];

		boolean flag = n > 0;
		boolean posi = flag;
		int max = n;
		int sum = n;
		for (int i = 1; i < len; i++) {
			int num = nums[i];
			max = Math.max(max, num);
			boolean next = num > 0;
			posi = posi | next;
			if (next == flag) {
				sum += num;
			} else {
				list.add(sum);
				flag = next;
				sum = num;
			}
		}
		if (!posi)
			return max;
		if (sum >= 0)
			list.add(sum);
		if (list.get(0) < 0)
			list.remove(0);

		while (list.size() > 8) {
			int a = list.get(0);
			int b = list.get(1);
			max = Math.max(a, max);

			if (a < -b) {
				list.remove(0);
				list.remove(0);
			} else {
				int c = list.get(2);
				list.set(2, a + b + c);
				list.remove(0);
				list.remove(0);
			}
		}

		int s = list.size();
		int[] a = new int[s];
		for (int i = 0; i < s; i++)
			a[i] = list.get(i);

		return maxSubArray2(a, max);
	}

	int maxSubArray2(int[] nums, int mm) {

		max = mm;
		int len = nums.length;
		int[][] temp = new int[len][len];
		boolean[][] visited = new boolean[len][len];

		for (int i = 0; i < len; i++)
			for (int j = i; j < len; j++)
				helper(i, j, temp, visited, nums);

		return max;
	}

	int helper(int start, int end, int[][] temp, boolean[][] visited,
	           int[] nums) {
		if (visited[start][end] == true)
			return temp[start][end];
		visited[start][end] = true;
		int ret = 0;
		if (start == end) {
			ret = nums[start];
		} else if (start == end - 1) {
			ret = nums[start] + nums[end];
		} else {
			int mid = (start + end) / 2;
			ret = helper(start, mid, temp, visited, nums) +
			      helper(mid + 1, end, temp, visited, nums);
		}
		max = Math.max(max, ret);
		temp[start][end] = ret;
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
		System.out.println(maxSubArray(new int[] {
		    -32, -54, -36, 62, 20, 76, -1, -86, -13, 38, -58, -77, 17, 38, -17,
		    43, 32, -88, -19, -70, 95, 0, -64, 75, 15, -87, -26, 69, -95, -65,
		    -14, 18, -66, 81, 65, -46, 70, 58, 65, 44, -68, -69, 7, -32, 47, 35,
		    -72, -96, 54, 30, -87, -46, -43, -17, -29, -10, -76, 26, 25, -11,
		    75, -89, -92, -91, 68, 49, -61, 38, -16, -95, -18, 15, -88, 65, 59,
		    58, 0, 63, 62, -68, -30, 51, -15, 4, -66, 32, 93, -65, -65, 18, 23,
		    -90, 5, 7, 94, -27, -66, -89, 87, 17, -85, -54, -90, -97, -89, 68,
		    60, -12, 9, -1, -4, 78, -49, 80, -18, -39, -11, -47, -5, 23, 47, 95,
		    9, -47, 2, -20, 2, 12, -10, -10, -70, -19, 12, -84, -17, 23, 60,
		    -56, 87, -31, 42, -17, -52, 69, -60, 6, -69, 5, 58, 25, -95, 6, 20,
		    -10, 35, 99, 69, -63, 11, -63, 3, 17, 17, -84, 32, 77, 15, -7, 97,
		    2, 61, 39, 61, 85, -14, 77, -31, 16, -18, -96, -82, -14, 9, 15, 75,
		    -79, -9, 21, -42, -98, 57, 37, -4, -25, 52, -72, -71, -33, -3, -74,
		    45, -64, 41, -17, 97, -73, -40, -34, 19, 41, -30, 37, -73, 55, -71,
		    78, 53, 19, 0, -89, -3, -43, 47, 92, 8, -23, 97, 36, 43, -29, 61,
		    -34, 6, 3, 48, 4, 6, 85, 46, -74, 26, 92, 39, 30, 25, 67, -15, -22,
		    -14, 84, -35, 82, -81, 88, 75, 26, -35, 49, -60, 85, -80, 77, -49,
		    3, -43, 75, -93, 63, 60, 29, 65, -36, -1, 4, 70, -76, -29, -45, 1,
		    56}));
	}
}
