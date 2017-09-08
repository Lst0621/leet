// url: https://leetcode.com/problems/remove-boxes/description/
package rmbox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//fixme
public class Solution {

	/** Ctrl + C starts here **/
	public int removeBoxes(int[] boxes) {
		System.out.println(boxes.length);


		return trim(boxes);
	}


	/** Ctrl + C ends here **/

	private int trim (int[] boxes){
		for(int num:boxes) {
			System.out.print(num + " ");
		}
		System.out.println("");
		int len = boxes.length;
		if(len<=1) return len;
		int last = boxes[0];
		Map<Integer,Pair> map = new HashMap<>();
		int index = 0;
		for(int i=1;i<len;i++){
			if(boxes[i]==last){
				continue;
			}
			else {
				if(map.containsKey(last)){
					map.put(last,new Pair(-1,-1));
				}
				else {
					map.put(last,new Pair(index,i-1));
				}
				index = i;
				last = boxes[i];
			}
		}
		if(map.containsKey(last)){
			map.put(last,new Pair(-1,-1));
		}
		else {
			map.put(last,new Pair(index,len-1));
		}


		//Integer sum = new Integer(0);
		int sum = 0;
		int count = 0;
		for(Map.Entry<Integer,Pair> entry:map.entrySet()) {
			Pair p = entry.getValue();
			if(p.start!=-1){

				int diff = p.end-p.start+1;
				sum += diff*diff;
				count += diff;
				for(int k=p.start;k<=p.end;k++)
					boxes[k] = -1;
			}
		}
		System.out.println(map);
		System.out.println("count: "+count);
		if(count>0) {
			int[] trimed = new int[boxes.length - count];
			int j = 0;
			for (int i = 0; i < boxes.length; i++) {
				if (boxes[i] != -1)
					trimed[j++] = boxes[i];

			}
			sum += trim(trimed);
		}
		else {
			sum+= removeBoxes2(boxes);
		}
		System.out.println("sum: "+sum);
		return sum;
	}
	class Pair{
		int start;
		int end;
		public Pair(int start,int end){
			this.start = start;
			this.end = end;
		}
		public String toString(){
			return "start: "+start+" end: "+end;
		}
	}

	HashMap<String,Integer> map = new HashMap<>();
	public int removeBoxes2(int[] boxes) {
		int len = boxes.length;
		if(len==0) return 0;
		if(len==1) return boxes[0]*boxes[0];
		boolean[] visited = new boolean[len];
		for(int num:boxes){
			System.out.println(num);
		}
		return helper(boxes,visited,len);
		//return 0;

	}

	private int helper(int[] boxes,boolean[] visited,int len){
		int max = 0;
		StringBuilder sb = new StringBuilder();
		for(boolean bit:visited){
			if(bit) sb.append('1');
			else
				sb.append('0');
		}
		String pattern = sb.toString();
		System.out.println(pattern);
		Integer ret = map.get(pattern);
		if(ret!=null) return(ret);


		for(int i=0;i<len;){
			if(visited[i]==true) {
				i++;
				continue;
			}

			int cnt = 0;
			int num = boxes[i];
			Set<Integer> list = new HashSet<>();
			int j=i;
			for(;j<len;j++){
				if(visited[j]==false) {
					if(boxes[j]!=num){
						break;
					}
					else {
						list.add(j);
						visited[j]=true;
						cnt++;

					}

				}
			}
			int temp = cnt*cnt+helper(boxes,visited,len);
			list.forEach(item->visited[item]=false);
			if(temp>max) max =temp;
			i = j;

		}
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
