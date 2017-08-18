// url: https://leetcode.com/problems/pascals-triangle/description/
package pascalTri;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/** Ctrl + C starts here **/

	public List<Integer> getRow(int rowIndex) {

		List<Integer> list = new ArrayList<>();

		list.add(1);
		if (rowIndex <= 0)
			return list;
		for (int i = 1; i <= rowIndex; i++) {
			modiList(list, i);
		}

		return list;
	}
	private void modiList(List<Integer> list, int len) {
		int temp = 1;
		for (int i = 1; i < len; i++) {
			int num = list.get(i);
			list.set(i, num + temp);
			temp = num;
		}
		list.add(1);
	}

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> res = new ArrayList<>();
		if (numRows <= 0)
			return res;
		List<Integer> list = new ArrayList<>();
		list.add(1);
		res.add(list);
		for (int i = 2; i <= numRows; i++) {
			list = genList(list);
			res.add(list);
		}

		return res;
	}

	private List<Integer> genList(List<Integer> list) {
		List<Integer> bottom = new ArrayList<>();
		int mem = 0;
		for (Integer num : list) {
			bottom.add(mem + num);
			mem = num;
		}
		bottom.add(1);
		return bottom;
	}

	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		System.out.println(getRow(4).toString());
	}
}
