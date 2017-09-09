//url: https://leetcode.com/problems/maximum-length-of-pair-chain/description/
package maxLenPair;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	/** Ctrl + C starts here **/
	public int findLongestChain(int[][] pairs) {
		TreeSet<Pair> set = new TreeSet<>();
		int min = 0;
		int max = 100;
		for(int[] pair:pairs) {
			set.add(new Pair(pair[0], pair[1]));
			if(pair[0]<min) min = pair[0];
			if(pair[1]>max) max = pair[1];
		}

		int count = 0;
		Pair last = new Pair(min-1,min-1);
		while(true){

			Set<Pair> maybe = (set.tailSet(last));

			if(maybe.size()==0)
				return count;
			count++;

			Pair next = new Pair(max+1,max+1);
			for(Pair p:maybe){
				if(p.end<next.end)
					next = p;
			}
			//System.out.println(next);
			last = new Pair(next.end+1,next.end+2);

		}

	}

	class Pair implements Comparable<Pair>{
		int start;
		int end;
		public Pair(int start,int end){
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Pair pair) {


			if(this.start==pair.start){
				return this.end-pair.end;
			}
			return this.start - pair.start;
		}
		public String toString(){
			return start+ " " + end;
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
		int[][] inputs = new int[][]{{1,2},{1,3},{1,4},{2,9},{3,5},{2,4},{4,6},{7,100},{9,12},{13,14}};
		System.out.println(findLongestChain(inputs));
	}
}
