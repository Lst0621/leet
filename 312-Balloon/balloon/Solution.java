//url: https://leetcode.com/problems/burst-balloons/description/
package balloon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


/**
 *
 *   nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

public class Solution {
	//fixme
	/** Ctrl + C starts here **/

	int[][] temp;
	public int maxCoins(int[] nums) {
		int l = nums.length;
		if(l==0) return 0;
		temp = new int[l][l];
		for(int i=0;i<l;i++)
			for(int j=0;j<l;j++)
				temp[i][j] = -1;
		int ret =  helper(nums,0,l-1,1,1);
		return ret;
	}

	private int helper(int[] nums,int start,int end,int a,int b){
		//System.out.println(start +  " " + end);
		if(end<start) return 0;
		if(end==start) return a*b*fetch(nums,start);

		if(temp[start][end]!=-1)
			return temp[start][end];
		int ret = 0;

		for(int i=start;i<=end;i++){
			int sum = a*b*fetch(nums,i) + helper(nums,start,i-1,a,fetch(nums,i))+helper(nums,i+1,end,fetch(nums,i),b);
			if(ret<sum)
				ret = sum;
		}
		temp[start][end] = ret;
		return ret;
	}

	private int fetch(int[] nums,int index){
		if(index<0||index>=nums.length)
			return 1;
		return nums[index];
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
		System.out.println(maxCoins(new int[]{8,2,6,8,9,8,1,4,1,5,3,7,7,0,4,2,2,5}));
		//System.out.println(maxCoins(new int[]{1,2}));
	}
}
