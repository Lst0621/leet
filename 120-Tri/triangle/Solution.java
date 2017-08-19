//url: https://leetcode.com/problems/triangle/description/
package triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	/** Ctrl + C starts here **/
	public int minimumTotal(List<List<Integer>> triangle) {
		int len = triangle.size();
		if(len==0) return 0;
		List<Integer> ret = triangle.get(0);
		for(int i=1;i<len;i++){
			ret = add(ret,triangle.get(i),i+1);

		}

		return Collections.min(ret);

	}

	private List<Integer> add(List<Integer> up, List<Integer> down, int len){
		List<Integer> ret= new ArrayList<>(len);
		ret.add(up.get(0)+down.get(0));
		for(int i=1;i<len-1;i++)
			ret.add(down.get(i)+Math.min(up.get(i),up.get(i-1)));

		ret.add(up.get(len-2)+down.get(len-1));
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
		List<List<Integer>> tri = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(2);
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		list2.add(3);
		list2.add(4);
		list3.add(6);
		list3.add(5);
		list3.add(7);
		tri.add(list1);
		tri.add(list2);
		tri.add(list3);
		System.out.println(tri);
		System.out.println(minimumTotal(tri));


	}
}
