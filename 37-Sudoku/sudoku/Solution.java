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

	private boolean[][] rows;
	private boolean[][] cols;
	private boolean[][][] sqr;

	List<int[]> list = new ArrayList<>(81);
	public void solveSudoku(char[][] board) {
		rows = new boolean[9][9];
		cols = new boolean[9][9];
		sqr = new boolean[3][3][9];

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c == '.') {
					list.add(new int[] {i, j});
				} else {
					rows[i][c - '1'] = true;
					cols[j][c - '1'] = true;
					sqr[getIndex(i)][getIndex(j)][c - '1'] = true;
				}
			}
		helper(list, board, 0);
	}

	private boolean helper(List<int[]> list, char[][] board, int index) {
		int[] coor = list.get(index);
		int x = coor[0];
		int y = coor[1];
		boolean[] set0 = rows[x];
		boolean[] set1 = cols[y];
		boolean[] set2 = sqr[getIndex(x)][getIndex(y)];
		boolean ret = false;
		for (char c = '1'; c <= '9'; c++) {
			if (set0[c - '1'])
				continue;
			if (set1[c - '1'])
				continue;
			if (set2[c - '1'])
				continue;
			set0[c - '1'] = true;
			set1[c - '1'] = true;
			set2[c - '1'] = true;
			board[x][y] = c;
			if (index == list.size() - 1) {
				return true;
			}
			ret = helper(list, board, index + 1);
			if (ret)
				return true;
			set0[c - '1'] = false;
			set1[c - '1'] = false;
			set2[c - '1'] = false;
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
