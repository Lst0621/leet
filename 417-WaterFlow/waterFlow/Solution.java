// url: https://leetcode.com/problems/pacific-atlantic-water-flow/description/
package waterFlow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	private static int PAC = 1;
	private static int ATL = 2;

	/** Ctrl + C starts here **/
	public List<int[]> pacificAtlantic(int[][] matrix) {
		int m = matrix.length;
		List<int[]> res = new ArrayList<>();
		if(m==0) return res;
		int n = matrix[0].length;

		int[][] water = new int[m][n];
		Queue<Integer> q = new LinkedList<>();

		// check PAC starts
		for (int i = 0; i < n; i++) {
			water[0][i] += PAC;
			q.add(0);
			q.add(i);
		}
		for (int i = 1; i < m; i++) {
			water[i][0] += PAC;
			q.add(i);
			q.add(0);
		}
		flash(PAC, matrix, m, n, water, q);

		// check ATL starts
		for (int i = 0; i < n; i++) {
			water[m-1][i] += ATL;
			q.add(m-1);
			q.add(i);
		}
		for (int i = 0; i < m-1; i++) {
			water[i][n-1] += ATL;
			q.add(i);
			q.add(n-1);
		}
		flash(ATL, matrix, m, n, water, q);


		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				if(water[i][j]==ATL+PAC){
			res.add(new int[]{i,j});
				}


		return res;
	}

	private void up(int x, int y, int num, int thres, int[][] matrix,
	                int[][] water, Queue<Integer> q) {
		if (matrix[x][y] >= num) {
			if (water[x][y] < thres) {
				water[x][y] += thres;
				q.add(x);
				q.add(y);
			}
		}
	}

	private void flash(int thres, int[][] matrix, int m, int n, int[][] water,
	                   Queue<Integer> q) {
		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			int num = matrix[x][y];

			if (x + 1 < m)
				up(x + 1, y, num, thres, matrix, water, q);
			if (x - 1 >= 0)
				up(x - 1, y, num, thres, matrix, water, q);
			if (y + 1 < n)
				up(x, y + 1, num, thres, matrix, water, q);
			if (y - 1 >= 0)
				up(x, y - 1, num, thres, matrix, water, q);
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

		int[][] matrix = {{1, 2, 2, 3, 5},
		                 {3, 2, 3, 4, 4},
		                 {2, 4, 5, 3, 1},
		                 {6, 7, 1, 4, 5},
		                 {5, 1, 1, 2, 4}};
		List<int[]> res = pacificAtlantic(matrix);
		res.forEach(item -> System.out.println(item[0] + " " + item[1]));
	}
}
