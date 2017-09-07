//url: https://leetcode.com/problems/palindrome-partitioning/description/
package palindromePart;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * Ctrl + C starts here
	 **/
	public List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<>();
		List<String> list = new ArrayList<>();

		int len = s.length();
		String[][] dic = new String[len][len];
		boolean[][] map = new boolean[len][len];
		builderMap(map, s, len);
		helper(ret, list, s, 0, map, dic);
		return ret;
	}

	private void helper(List<List<String>> ret, List<String> list, String s, int index, boolean[][] map, String[][] dic) {
		if (index == s.length()){
			ret.add(new ArrayList<>(list));
			return;
		}

		for(int i = index;i<s.length();i++) {
			if (map[index][i] == true) {
				list.add(index2Str(index, i, s, dic));
				helper(ret, list, s, i + 1, map, dic);
				list.remove(list.size() - 1);
			}
		}
	}


	private String index2Str(int start,int end,String s,String[][] dic){
		String res = dic[start][end];
		if(res!=null) return res;
		res= s.substring(start,end+1);
		dic[start][end] = res;
		return res;
	}

	private void builderMap(boolean[][] map,String s,int len){
		for(int i=0;i<len;i++){;
			map[i][i]=true;
		}

		for(int mid=1;mid<len-1;mid++){
			int x = mid-1;
			int y = mid+1;
			while(x>=0&&y<len){
				if(s.charAt(x)==s.charAt(y)){
					map[x][y]=true;
					x--;
					y++;

				}
				else {
					break;
				}
			}
		}

		for(int mid=0;mid<len-1;mid++){
			int x = mid;
			int y = mid+1;
			while(x>=0&&y<len){
				if(s.charAt(x)==s.charAt(y)){
					map[x][y]=true;
					y++;
					x--;
				}
				else {
					break;
				}
			}
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
		String word = "abcabcaaadda";
		System.out.println(partition(word));
	}
}
