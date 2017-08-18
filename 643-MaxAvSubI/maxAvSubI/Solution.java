//url: https://leetcode.com/problems/maximum-average-subarray-i/description/
package maxAvSubI;
public class Solution {

	/**
	 * 	Input: [1,12,-5,-6,50,3], k = 4
	 *  Output: 12.75
	 *  Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
	 */


	/** Ctrl + C starts here **/
	public double findMaxAverage(int[] nums, int k) {
		int len = nums.length;
		int i=0;
		int j=0;
		int sum = 0;
		for(;i<k;i++){
			sum+=nums[i];
		}
		int max = sum;
		for(;i<len;i++){
			sum+=nums[i];
			sum-=nums[j];
			j++;
			if(max<sum)
				max = sum;


		}
		return (double) max/k;


	}


	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();

	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		int[] nums = {1,12,-5,-6,50,3};
		System.out.println(findMaxAverage(nums,4));
	}
}
