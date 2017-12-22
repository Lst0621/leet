// url: https://leetcode.com/problems/sudoku-solver/description/
package sudoku;
import java.util.*;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃ 　
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃　　　　　　　　　　　
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + 　　　
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+　　　　　　　　　
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * */

public class Solution {
	/** Ctrl + C starts here **/
	private int getIndex(int i) { return i / 3; }

	private List<Set<Character>> rows;
	private List<Set<Character>> cols;
	private List<List<Set<Character>>> sqr;

	List<int[]> list = new ArrayList<>(81);
	public void solveSudoku(char[][] board) {
		rows = new ArrayList<>(9);
		for (int i = 0; i < 9; i++)
			rows.add(new HashSet<>());
		cols = new ArrayList<>(9);
		for (int i = 0; i < 9; i++)
			cols.add(new HashSet<>());
		sqr = new ArrayList<>(3);
		for (int i = 0; i < 3; i++) {
			sqr.add(new ArrayList<>());
			for (int j = 0; j < 3; j++)
				sqr.get(i).add(new HashSet<>());
		}

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c == '.') {
					list.add(new int[] {i, j});
				} else {
					rows.get(i).add(c);
					cols.get(j).add(c);
					sqr.get(getIndex(i)).get(getIndex(j)).add(c);
				}
			}
		helper(list, board, 0);
	}

	private boolean helper(List<int[]> list, char[][] board, int index) {
		int[] coor = list.get(index);
		int x = coor[0];
		int y = coor[1];
		Set<Character> set0 = rows.get(x);
		Set<Character> set1 = cols.get(y);
		Set<Character> set2 = sqr.get(getIndex(x)).get(getIndex(y));
		boolean ret = false;
		for (char c = '1'; c <= '9'; c++) {
			if (set0.contains(c))
				continue;
			if (set1.contains(c))
				continue;
			if (set2.contains(c))
				continue;
			set0.add(c);
			set1.add(c);
			set2.add(c);
			board[x][y] = c;
			if (index == list.size() - 1) {
				return true;
			}
			ret = helper(list, board, index + 1);
			if (ret)
				return true;
			set0.remove(c);
			set1.remove(c);
			set2.remove(c);
		}
		return false;
	}

	/** Ctrl + C ends here **/
	private void show(char[][] board) {
		for (char[] array : board) {
			for (char c : array)
				System.out.print(c + " ");
			System.out.println("");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		System.out.println("");
		char[][] board = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'},
		                  {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
		                  {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
		                  {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
		                  {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
		                  {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
		                  {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
		                  {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
		                  {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
		show(board);
		solveSudoku(board);
		show(board);
		System.out.println("Done!");
	}
}
