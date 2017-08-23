// url: https://leetcode.com/problems/next-greater-element-i/description/
package nextGreaterI;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 **/

public class Solution {

	/** Ctrl + C starts here **/
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int[] res = new int[len1];
		if (len1==0||len2==0) return res;
		TreeSet<Integer> set = new TreeSet<>();
		Map<Integer,Integer> map = new HashMap<>();

		for(int i=0;i<len2;i++) {
			int num = nums2[i];
			set.add(num);
			while(true) {
				Integer low = set.lower(num);
				if(low==null) break;
				map.put(low,num);
				set.remove(low);
			}
		}

		for(int i=0;i<len1;i++){
			Integer poten =map.get(nums1[i]);
			if(poten==null)
				res[i] = -1;
			else
				res[i] = poten;

		}
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
		int[] nums1 = {4, 1, 2};
		int[] nums2 = {1, 3, 4, 2};
		int[] ans = nextGreaterElement(nums1,nums2);
		for (int i:ans){
			System.out.print(i+ "  ");
		}
	}
}
