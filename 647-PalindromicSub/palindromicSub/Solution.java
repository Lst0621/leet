//url: https://leetcode.com/problems/palindromic-substrings/description/

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes
 * or end indexes are counted as different substrings even they consist of same characters.
 */
package palindromicSub;
public class Solution {

	/** Ctrl + C starts here **/
	public int countSubstrings(String s) {
		int len = s.length();
		if(len<=0) return len;
		int count = len;
		int[][] res = new int[len][len];
		for(int i=0;i<len;i++){
			res[i][i]=1;
		}
		char[] chars = s.toCharArray();
		for(int i=0;i<len-1;i++)
			for(int j=i+1;j<len;j++){
			if(check(i,j,res,chars)) count++;
			}
		return count;

	}

	private boolean check(int head,int tail,int[][]res,char[] chars){
		System.out.println(head+" "+tail);
		int num = res[head][tail];
		if(num==1) return true;
		if(num==2) return false;
		if(chars[head]!=chars[tail]) {
			res[head][tail]=2;
			return false;
		}
		if(head==tail-1){
			res[head][tail]=1;
			return true;
		}
		boolean ret = check(head+1,tail-1,res,chars);
		if(ret)
			res[head][tail]=1;
		else
			res[head][tail]=2;
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
		String str = "abcbasfadsfasfvasdfeeqwqq";
		System.out.println(countSubstrings(str));
	}
}
