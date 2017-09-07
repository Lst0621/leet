//url: https://leetcode.com/problems/matchsticks-to-square/description/
package matchToSqu;

import java.util.Arrays;

public class Solution {
	/** Ctrl + C starts here **/
	public boolean makesquare(int[] nums) {
		int n = nums.length;
		if(n<4) return false;

		Arrays.sort(nums);
		for(int i=0;i<=n/2;i++){
			int temp = nums[i];
			nums[i] = nums[n-i-1];
			nums[n-i-1] = temp;
		}

		int sum = 0;
		for(int num:nums){
			sum+=num;
		}
		if(sum%4!=0) return false;
		int part = sum/4;
		if(nums[0]>part) return false;
		System.out.println(part);
		return helper(nums,1,part,n,nums[0],0,0,0);
	}

	private boolean helper(int[] nums, int index,int target, int len ,int sumA,int sumB, int sumC, int sumD){
		if(index==len) return true;
		int num = nums[index];
		boolean ret = false;
		if(sumA+num<=target)
			ret = ret||helper(nums,index+1,target,len,sumA+num,sumB,sumC,sumD);
		if(sumB+num<=target)
			ret = ret||helper(nums,index+1,target,len,sumA,sumB+num,sumC,sumD);
		if(sumC+num<=target)
			ret = ret||helper(nums,index+1,target,len,sumA,sumB,sumC+num,sumD);
		if(sumD+num<=target)
			ret = ret||helper(nums,index+1,target,len,sumA,sumB,sumC,sumD+num);

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
		System.out.println(makesquare(new int[]{8,8,8,8,8}));
	}
}
