// url: https://leetcode.com/problems/binary-watch/description/

package binwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08",
 *"0:16", "0:32"]
 *
 **/

public class Solution {

	/** Ctrl + C starts here **/
	//really bad
	//fixme 
	public List<String> readBinaryWatch(int num) {
		List<String> list = new ArrayList<>();
		for (int i=0;i<=Math.min(num,4);i++) {
			if (num-i>6) continue;
			List<Integer> hour = FourChooseN(i);
			for(int j=0;j<=Math.min(num-i,4);j++) {
				int left = num - i -j;
				if(left>2) continue;
				combine(hour,FourChooseN(j),TwoChooseN(left),list);
			}

		}
		return list;
	}
	private void combine(List<Integer> hour,List<Integer> minH,List<Integer> minL,List<String> list){
		hour.forEach(hh->{
			if(hh<12)
			minH.forEach(mh->{
				minL.forEach(ml->{
					int mm = mh*4+ml;
					if(mm<=59) {
						StringBuilder sb = new StringBuilder();
						sb.append(String.valueOf(hh));
						if (mm < 10) {
							sb.append(":0");
						} else {
							sb.append(":");
						}
						sb.append(String.valueOf(mm));
						list.add(sb.toString());
					}

				});
			});

		});


	}

	private List<Integer> FourChooseN(int n) {
		List<Integer> list = new ArrayList<>();
		switch (n) {
			case 0:
				return Arrays.asList(new Integer[]{0});
			case 1:
				return Arrays.asList(new Integer[]{8,4,2,1});
			case 2:
				return Arrays.asList(new Integer[]{12,10,9,6,5,3});
			case 3:
				return Arrays.asList(new Integer[]{7,11,13,14});
			default:
				return Arrays.asList(new Integer[]{15});


		}
	}


	private List<Integer> TwoChooseN(int n) {
		List<Integer> list = new ArrayList<>();
		switch (n) {
			case 0:
				return Arrays.asList(new Integer[]{0});
			case 1:
				return Arrays.asList(new Integer[]{2,1});
			default:
				return Arrays.asList(new Integer[]{3});
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
		int num = 6;
		System.out.println(readBinaryWatch(num).toString());
	}
}
