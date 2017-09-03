//url: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
package phoneCom;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/** Ctrl + C starts here **/
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		List<Character> used= new ArrayList<>();
		int len = digits.length();
		if(len==0) return res;
		helper(res,used,digits.toCharArray(),0,len,0);
		return res;
	}

	private void helper(List<String> res, List<Character> used,char[] array,int index,int len,int size){
		if(index==len){
			StringBuilder sb = new StringBuilder();
			used.forEach(item->sb.append(item));
			res.add(sb.toString());
			return;
		}
		List<Character> letters = num2char(array[index]);
		letters.forEach(item->{
			used.add(item);
			helper(res,used,array,index+1,len,size+1);
			used.remove(size);
		});

	}
		private List<Character> num2char(char num){
		List<Character> res = new ArrayList<>();
		switch(num) {
			case '9':
				res.add('w');
				res.add('x');
				res.add('y');
				res.add('z');
				return res;
			case '8':
				res.add('t');
				res.add('u');
				res.add('v');
				return res;
			case '7':
				res.add('p');
				res.add('q');
				res.add('r');
				res.add('s');
				return res;
			default:
				char c = (char) ('a' + 3 * (num - '2'));
				res.add(c);
				c++;
				res.add(c);
				c++;
				res.add(c);
				return res;
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
		String nums = "23";
		System.out.println(nums);
		System.out.println(letterCombinations(nums).toString());
	}
}
