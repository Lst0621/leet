// url: https://leetcode.com/problems/target-sum/description/
package targetSum;

import java.util.HashMap;

public class Solution {

	class Pair {
		Integer index;
		Integer S;
		public Pair(int index, int S) {
			this.index = index;
			this.S = S;
		}
		public String toString() { return index + " " + S; }

		@Override
		public boolean equals(Object o) {
			if (o == null)
				return false;
			if (o == this)
				return true;
			if (o.getClass() != getClass())
				return false;
			Pair p = (Pair)o;
			return (index.equals(p.index)) && (S.equals(p.S));
		}
		public int hashCode(){
			return new Integer((index+123)*(S+107)).hashCode();
		}
	}


	/** Ctrl + C starts here **/
	HashMap<Pair, Integer> map;
	int[] high;

	public Solution() { map = new HashMap<>(); }

	public int findTargetSumWays(int[] nums, int S) {

		int len = nums.length;
		high = new int[len];
		int h = 0;
		for(int i=len-1;i>=0;i--){
			h += nums[i];
			high[i] = h;
		}
		return helper(nums, len, 0, S);
	}
	private int helper(int[] nums, int len, int index, int S) {

		Pair pair = new Pair(index, S);
		int hash = pair.hashCode();

		//System.out.println(pair+": "+hash);
		Integer cnt = map.get(pair);
		if (cnt != null) {

			return cnt;
		}
		if(Math.abs(S)>high[index]){
			map.put(pair,0);
			return 0;

		}

		int num = nums[index];
		if (index == len - 1) {

			int sum = 0;
			if (num == S)
				sum++;
			if (num == -S)
				sum++;
			map.put(pair, sum);

			return sum;
		}
		int ret = helper(nums, len, index + 1, S - num) +
		          helper(nums, len, index + 1, S + num);
		map.put(pair, ret);

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
		System.out.println(this.findTargetSumWays(new int[]{1, 1, 1, 1, 1},3));
	}
}

