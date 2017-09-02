// url: https://leetcode.com/problems/valid-square/description/
/**
 *
 * Given the coordinates of four points in 2D space,
 * return whether the four points could construct a square.
 * The coordinate (x,y) of a point is represented by an integer array with two
 *integers.
 */
package validSqu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	/** Ctrl + C starts here **/
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		List<Pair> list = new ArrayList<>(4);

		list.add(new Pair(p1));
		list.add(new Pair(p2));
		list.add(new Pair(p3));
		list.add(new Pair(p4));

		Collections.sort(list);
		list.forEach(item -> System.out.println(item));

		Pair a = list.get(0);
		Pair b = list.get(1);
		Pair c = list.get(2);
		Pair d = list.get(3);
		if(a.compareTo(b)==0) return false;
		if (Pair.Sum(a, d).compareTo(Pair.Sum(b, c)) != 0)
			return false;

		boolean ret = check90(Pair.Minus(a, b), Pair.Minus(a, c)) &&
		              check90(Pair.Minus(a, d), Pair.Minus(b, c));
		return ret;
	}

	public boolean check90(Pair a, Pair b) {
		int sum = a.x * b.x + a.y * b.y;
		return sum == 0;
	}

	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		int[] a = {1, 1};
		int[] b = {0, 0};
		int[] c = {1, 0};
		int[] d = {0, 1};
		System.out.println(validSquare(a, b, c, d));
	}
}

class Pair implements Comparable<Pair> {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair(int[] array) { this(array[0], array[1]); }

	@Override
	public int compareTo(Pair Pair) {
		int diff = x - Pair.x;
		return diff != 0 ? diff : y - Pair.y;
	}

	public String toString() { return x + "   " + y; }

	public static Pair Sum(Pair a, Pair b) {
		return new Pair(a.x + b.x, a.y + b.y);
	}

	public static Pair Minus(Pair a, Pair b) {
		return new Pair(a.x - b.x, a.y - b.y);
	}
}
