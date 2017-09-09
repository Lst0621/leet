// url: https://leetcode.com/problems/remove-boxes/description/
package rmbox;

import java.util.*;

//fixme
public class Solution {

	/** Ctrl + C starts here **/
	public int removeBoxes(int[] boxes) {
		int len = boxes.length;
		if(len==0) return 0;
		if(len==1) return boxes[0]*boxes[0];
		boolean[] visited = new boolean[len];
		for(int num:boxes){
			System.out.println(num);
		}
		return helper(boxes,visited,len);
	}


	Map<String,Integer> map = new HashMap<>();
	int pats = 0;

	private int helper(int[] boxes,boolean[] visited,int len){
		StringBuilder sb = new StringBuilder();
		for(boolean bit:visited){
			if(bit) sb.append('1');
			else
				sb.append('0');
		}
		String pattern = sb.toString();

		Integer ret = map.get(pattern);
		if(ret!=null) {
			System.out.println("cache!");
			return (ret);
		}
		System.out.println("not cache!");

		pats++;
//		if(pats%1000==0) {
//			System.out.println(pats + ": " + pattern);
//			for(int i=1;i<len;i++)
//				if(visited[i]==false){
//					System.out.print(boxes[i]+" ");
//				}
//			System.out.println("");
//		}

		Map<Integer,List<List<Integer>>> sameNum = new HashMap<>();


		for(int i=0;i<len;){
			if(visited[i]==true) {
				i++;
				continue;
			}
			int num = boxes[i];
			List<Integer> list = new ArrayList<>();
			int j=i;
			for(;j<len;j++){
				if(visited[j]==false) {
					if(boxes[j]!=num){
						break;
					}
					else {
						list.add(j);
						//visited[j]=true;
						//cnt++;
					}
				}
			}
			List<List<Integer>> numList = sameNum.get(num);
			if(numList==null) {
				numList = new ArrayList<>();
				sameNum.put(num,numList);
			}
			numList.add(list);

			i = j;

		}


		ArrayList<Integer> lonely = new ArrayList<>();
		int max = 0;
		for(Map.Entry<Integer,List<List<Integer>>> entry:sameNum.entrySet()){
			List<List<Integer>> value = entry.getValue();
			if(value.size()==1){
				List<Integer> list = value.get(0);
				list.forEach(item->visited[item]=true);
				lonely.addAll(list);
				max += list.size() * list.size();
			}
		}
		System.out.println(lonely.size());

		for(Map.Entry<Integer,List<List<Integer>>> entry:sameNum.entrySet()){
			List<List<Integer>> value = entry.getValue();
			if(value.size()>1){
				for(List<Integer> list:value){
					list.forEach(item->visited[item]=true);
					int temp = list.size() * list.size()+helper(boxes,visited,len);
					if(temp>max) max =temp;
					list.forEach(item->visited[item]=false);
				}
			}
		}


		lonely.forEach(item->visited[item]=false);



		map.put(pattern,max);
		return max;
	}


	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		System.out.println("");
		int[] input = {3, 8, 8, 5, 5, 3, 9, 2, 4, 4,  6, 5,  8, 4, 8,  6, 9,
		               6, 2, 8, 6, 4, 1, 9, 5, 3, 10, 5, 3,  3, 9, 8,  8, 6,
		               5, 3, 7, 4, 9, 6, 3, 9, 4, 3,  5, 10, 7, 6, 10, 7};
//		int[] input ={1, 2,1,2,2,1,2};
		System.out.println(removeBoxes(input));
	}
}
