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

	/** Ctrl + C starts here **/
	private HashMap<String,Integer> map;
	public int maxCoins(int[] nums) {
		int l = nums.length;
		if(l==0) return 0;
		map = new HashMap<>();
		List<Integer> list = new LinkedList<>();
		list.add(1);
		int sum = 0;
		int temp = 1;
		for(int i=0;i<l;i++){
			int num = nums[i];
			if(num>=1)
				list.add(num);
		}
		list.add(1);
		int ret =  helper(list);
		return ret;
	}

	private int helper(List<Integer> list){

		StringBuilder sb= new StringBuilder();
		for(int num:list){
			sb.append(" ");
			sb.append(num);
		}
		String str = sb.toString();
		//System.out.println(str);

		if(map.get(str)!=null) {
			//System.out.println("cache");
			return map.get(str);
		}
		int ret = 0;
		int s = list.size();
		if(s==3)
		{
			ret = list.get(1);
			map.put(str,ret);
			return ret;
		}



		for(int i=1;i<s-1;i++){
			int sum = list.get(i)*list.get(i-1)*list.get(i+1);
			int temp = list.get(i);
//			List<Integer> next = new ArrayList<>(list);
//			next.remove(i);
			list.remove(i);
			sum += helper(list);
			if(sum>ret)
				ret = sum;
			list.add(i,temp);
		}

		map.put(str,ret);
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
		System.out.println(maxCoins(new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5}));
		//System.out.println(maxCoins(new int[]{3,1,5,8}));
	}
}
