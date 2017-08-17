// url: https://leetcode.com/problems/4sum/description/

/* For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 *[
 *[-1,  0, 0, 1],
 *[-2, -1, 1, 2],
 *[-2,  0, 0, 2]
 *]
 **/

import java.util.*;
public class Solution {
	private int lastThree =0;
	private int lastTwo = 0;
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int len = nums.length;
		if (len < 4)
			return res;
		List<Integer> list = new ArrayList<>(len);
		for (int num : nums) {
			list.add(num);
		}
		Collections.sort(list);

		int i = 0;
		for (Integer num : list) {
			nums[i] = num;
			i++;
		}
		int temp = nums[0];

		if (temp * 4 > target)
			return res;

		lastTwo = nums[len-1]+ nums[len-2];
		lastThree = lastTwo+ nums[len-3];


		if (lastThree+ nums[len-4] < target)
			return res;
		for (int j = 0; j < len - 3; j++) {
			int num = nums[j];
			if (num != temp || j == 0) {
				List<List<Integer>> mid =
				    threeSum(nums, target - num, j + 1, len);
				mid.forEach(lis -> {
					lis.add(num);
					res.add(lis);
				});
				temp = num;
			}
		}
		return res;
	}

	private List<List<Integer>> threeSum(int[] nums, int target, int header,
	                                     int len) {
		List<List<Integer>> res = new ArrayList<>();
		if ((nums[header] + nums[header + 1] + nums[header + 2] > target ||
		     lastThree < target))
			return res;

		int temp = nums[header];
		for (int j = header; j < len - 2; j++) {
			int num = nums[j];
			if (num != temp || j == header) {
				List<List<Integer>> mid =
				    twoSum(nums, target - num, j + 1, len);
				mid.forEach(lis -> {
					lis.add(num);
					res.add(lis);
				});
				temp = num;
			}
		}

		return res;
	}

	private List<List<Integer>> twoSum(int[] nums, int target, int header,
	                                   int len) {
		List<List<Integer>> res = new ArrayList<>();
		if ((nums[header] + nums[header + 1] > target ||
		     lastTwo < target))
			return res;
		HashMap<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new TreeSet<>();
		int temp = nums[header];
		// todo make it fast
		boolean flag = false;
		map.put(temp, 1);
		set.add(temp);

		for (int i = header + 1; i < len; i++) {
			int num = nums[i];
			if (temp == num) {
				map.put(temp, 2);
			} else {
				temp = num;
				map.put(temp, 1);
				set.add(num);
			}
		}
		// fixme
		int thres = target > 0 ? target / 2 : (target - 1) / 2;
		set.forEach(item -> {
			int val = item.intValue();
			if (val <= thres) {
				boolean found = false;
				int another = target - item;
				if (set.contains(another)) {
					if (another == val) {
						if (map.get(val) == 2) {
							found = true;
						}
					} else {
						found = true;
					}
				}
				if (found) {
					List<Integer> ans = new ArrayList<>(4);

					ans.add(another);
					ans.add(val);
					//					System.out.println(thres);
					//					System.out.println(ans.toString());
					res.add(ans);
				}
			}
		});
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {
		    91277418,  66271374,  38763793,  4092006,   11415077,  60468277,
		    1122637,   72398035,  -62267800, 22082642,  60359529,  -16540633,
		    92671879,  -64462734, -55855043, -40899846, 88007957,  -57387813,
		    -49552230, -96789394, 18318594,  -3246760,  -44346548, -21370279,
		    42493875,  25185969,  83216261,  -70078020, -53687927, -76072023,
		    -65863359, -61708176, -29175835, 85675811,  -80575807, -92211746,
		    44755622,  -23368379, 23619674,  -749263,   -40707953, -68966953,
		    72694581,  -52328726, -78618474, 40958224,  -2921736,  -55902268,
		    -74278762, 63342010,  29076029,  58781716,  56045007,  -67966567,
		    -79405127, -45778231, -47167435, 1586413,   -58822903, -51277270,
		    87348634,  -86955956, -47418266, 74884315,  -36952674, -29067969,
		    -98812826, -44893101, -22516153, -34522513, 34091871,  -79583480,
		    47562301,  6154068,   87601405,  -48859327, -2183204,  17736781,
		    31189878,  -23814871, -35880166, 39204002,  93248899,  -42067196,
		    -49473145, -75235452, -61923200, 64824322,  -88505198, 20903451,
		    -80926102, 56089387,  -58094433, 37743524,  -71480010, -14975982,
		    19473982,  47085913,  -90793462, -33520678, 70775566,  -76347995,
		    -16091435, 94700640,  17183454,  85735982,  90399615,  -86251609,
		    -68167910, -95327478, 90586275,  -99524469, 16999817,  27815883,
		    -88279865, 53092631,  75125438,  44270568,  -23129316, -846252,
		    -59608044, 90938699,  80923976,  3534451,   6218186,   41256179,
		    -9165388,  -11897463, 92423776,  -38991231, -6082654,  92275443,
		    74040861,  77457712,  -80549965, -42515693, 69918944,  -95198414,
		    15677446,  -52451179, -50111167, -23732840, 39520751,  -90474508,
		    -27860023, 65164540,  26582346,  -20183515, 99018741,  -2826130,
		    -28461563, -24759460, -83828963, -1739800,  71207113,  26434787,
		    52931083,  -33111208, 38314304,  -29429107, -5567826,  -5149750,
		    9582750,   85289753,  75490866,  -93202942, -85974081, 7365682,
		    -42953023, 21825824,  68329208,  -87994788, 3460985,   18744871,
		    -49724457, -12982362, -47800372, 39958829,  -95981751, -71017359,
		    -18397211, 27941418,  -34699076, 74174334,  96928957,  44328607,
		    49293516,  -39034828, 5945763,   -47046163, 10986423,  63478877,
		    30677010,  -21202664, -86235407, 3164123,   8956697,   -9003909,
		    -18929014, -73824245};
		int target = -236727523;
		Solution sol = new Solution();
		List<List<Integer>> res = sol.fourSum(nums, target);
		System.out.println("Answer Size: " + res.size());
		res.forEach(item -> {
			System.out.println("*********");
			item.forEach(it -> System.out.print(" " + it + " "));
			System.out.println("");
		});
	}
}
