//url: https://leetcode.com/problems/sort-characters-by-frequency/description/
package sortByFre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {

	/** Ctrl + C starts here **/

	public String frequencySort(String s) {
		if (s == null) return s;
		int len = s.length();
		if (len <= 2) return s;

		HashMap<Character, Integer> map = new HashMap<>();
		Integer def = new Integer(0);
		for (char c : s.toCharArray()) {
			int cnt = map.getOrDefault(c, def);
			map.put(c, cnt + 1);
		}

		ArrayList<pair> list = new ArrayList<>(map.size());
		map.forEach((key,value)->{
			list.add(new pair(key,value));

		});
		Collections.sort(list,Collections.reverseOrder());
		StringBuilder sb =new StringBuilder();
		list.forEach(item->sb.append(item.toString()));

		return sb.toString();

	}




	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		System.out.println(frequencySort("hello"));
	}
}


	class pair implements  Comparable<pair>{
		char c;
		int cnt;
		pair(char c,int cnt){
		this.c=c;
		this.cnt =cnt;
		}

		@Override
		public int compareTo(pair pair) {
			return this.cnt-pair.cnt;
		}
		public String toString(){
			StringBuilder sb =new StringBuilder();
			for(int i=0;i<cnt;i++)
				sb.append(c);
			return sb.toString();
		}
	}