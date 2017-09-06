//url: https://leetcode.com/problems/palindrome-partitioning/description/
package palindromePart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

	/** Ctrl + C starts here **/
	public List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<>();
		List<String> list = new ArrayList<>();

		int len = s.length();
		String[][] dic = new String[len][len];
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		builderMap(map,s,len);
		helper(ret,list,s,0,map,dic);
		return ret;
	}
	private void helper(List<List<String>> ret,List<String> list,String s,int index, HashMap<Integer,List<Integer>> map,String[][] dic){
		List<Integer> dest = map.get(index);

		if(dest==null) {
			ret.add(new ArrayList<>(list));
			return;
		}

		dest.forEach(item->{
			list.add(index2Str(index,item,s,dic));
			helper(ret,list,s,item+1,map,dic);
			list.remove(list.size()-1);
		});

	}

	private String index2Str(int start,int end,String s,String[][] dic){
		String res = dic[start][end];
		if(res!=null) return res;
		res= s.substring(start,end+1);
		dic[start][end] = res;
		return res;
	}

	private void builderMap(HashMap<Integer,List<Integer>> map,String s,int len){
		for(int i=0;i<len;i++){
			List<Integer> list = new ArrayList<>(0);
			list.add(i);
			map.put(i,list);
		}

		for(int mid=1;mid<len-1;mid++){
			int x = mid-1;
			int y = mid+1;
			while(x>=0&&y<len){
				if(s.charAt(x)==s.charAt(y)){
					map.get(x).add(y);
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
					map.get(x).add(y);
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
