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
		List<List<Integer>> temp = new ArrayList<>();
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

		List<Integer> list = new ArrayList<>();
		temp.add(list);
		for(Map.Entry<Integer,Integer> pair:map.entrySet()){
			c--;
			keys[c]=pair.getKey();
			values[c]=pair.getValue();
		}
		helper(res,temp, keys,values,0, count);
		return res;

	}
	void helper(List<List<Integer>> res,List<List<Integer>> temp,int[] keys,int[] values,int index,int len) {
		if (index == len) {
			temp.forEach(item -> res.add(new ArrayList<>(item)));
			return;
		}
		helper(res, temp, keys, values, index + 1, len);
		int key = keys[index];
		int value = values[index];
		System.out.println(key+ " "+ value);
		System.out.println("");
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> next = new ArrayList<>();
		for (int i = 1; i <= value; i++) {
			list.add(key);
			temp.forEach(item ->
						item.addAll(list));
			helper(res, temp, keys, values, index + 1, len);
			temp.forEach(item ->
				item.removeAll(list));
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
