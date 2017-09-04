// url: https://leetcode.com/problems/restore-ip-addresses/description/
package restoreIP;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/** Ctrl + C starts here **/
	public List<String> restoreIpAddresses(String s) {
		int len = s.length();

		List<String> res = new ArrayList<>();
		List<Integer> ip = new ArrayList<>();
		helper(res,ip,s,len,-1,0);
		return res;
	}

	private boolean check(int num) { return num <= 255; }
	private void helper(List<String> res,List<Integer>ip,String s,int len,int index,int parts){
		if(parts==4) {
			if(index==len-1)
			res.add(ip2Str(ip));
			return;
		}
		if(index==len-1) return;
		int num = 0;
		for(int i=index+1;i<len;i++){
			num = num*10+s.charAt(i)-'0';
			if(check(num)==false) return;
			ip.add(num);
			helper(res,ip,s,len,i,parts+1);
			ip.remove(ip.size()-1);
			if(num==0) return;
		}

	}
	private String ip2Str(List<Integer> ip) {
		StringBuilder sb = new StringBuilder();
		sb.append(ip.get(0));
		sb.append('.');
		sb.append(ip.get(1));
		sb.append('.');
		sb.append(ip.get(2));
		sb.append('.');
		sb.append(ip.get(3));
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
		System.out.println("");
		String s = "0100107";
		restoreIpAddresses(s).forEach(item-> System.out.println(item));
	}
}
