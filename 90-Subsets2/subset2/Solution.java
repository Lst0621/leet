//url: https://leetcode.com/problems/subsets-ii/description/
package subset2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	HashMap<Integer,Integer> map;

	/** Ctrl + C starts here **/
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		map = new HashMap<>();
		Integer zero = new Integer(0);
		int count = 0;
		for(int num:nums){
			Integer cnt = map.getOrDefault(num,zero);
			if(cnt==0) count++;
			map.put(num,cnt+1);
		}
		int c = count;
		int[] keys = new int[count];
		int[] values = new int[count];
		int[] result = new int[count];


		for(Map.Entry<Integer,Integer> pair:map.entrySet()) {
			c--;
			keys[c] = pair.getKey();
			values[c] = pair.getValue();
		}




		helper(res,keys,values,result,0,count);
		return res;
	}

		private void helper(List<List<Integer>> res,
							int[] keys,int[] values,int[] result,int index,int count){
		if(index==count) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				int v = keys[i];
				for (int j = 0; j < result[i]; j++)
					list.add(v);
			}
			res.add(list);
			return;
		}
		for(int i=0;i<=values[index];i++){
			result[index] = i;
			helper(res,keys,values,result,index+1,count);
			}

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
		int[] nums = {1,2,2};
		System.out.println(subsetsWithDup(nums).toString());
	}
}
