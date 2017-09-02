//url: https://leetcode.com/problems/beautiful-arrangement/description/

/**
 * Input: 2
 * Output: 2
 * Explanation:
 * The first beautiful arrangement is [1, 2]:
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * The second beautiful arrangement is [2, 1]:
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 *
 *
 */
package beautyrange;

import java.util.LinkedList;

public class Solution {

	/** Ctrl + C starts here **/
	public int countArrangement(int N) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1;i<=N;i++)
			list.add(i);
		int pos = 1;
		return arrange(pos,N,list);
	}

	private int  arrange(int pos,int last,LinkedList<Integer> list){
		int cnt = 0;
		for(int num:list){
			if(num%pos==0||pos%num==0) {
				if(pos==last){
					System.out.println("Found!");
					cnt++;
				}
				else {
					LinkedList<Integer> left = (LinkedList<Integer>) list.clone();
					left.remove(new Integer(num));
					cnt += arrange(pos + 1, last, left);
				}
			}
		}
		return cnt;
	}


	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		System.out.println(countArrangement(12));
	}
}
