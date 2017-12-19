// url: https://leetcode.com/problems/design-snake-game/description/
package snake;
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
class SnakeGame {
	int w, h;
	boolean[][] board;
	int[][] food;
	int cnt;
	LinkedList<int[]> snake;
	static final boolean EMPTY = false;
	static final boolean BODY = true;

	/** Initialize your data structure here.
	 *         @param width - screen width
	 *                 @param height - screen height
	 *                         @param food - A list of food positions
	 *                                 E.g food = [[1,1], [1,0]] means the first
	 * food is positioned at [1,1], the second is at [1,0]. */
	public SnakeGame(int width, int height, int[][] food) {
		w = width;
		h = height;
		this.food = food;
		cnt = 0;
		board = new boolean[h][w];
		board[0][0] = BODY;
		snake = new LinkedList<>();
		snake.add(new int[] {0, 0});
	}

	/** Moves the snake.
	 *         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
	 *                 @return The game's score after the move. Return -1 if
	 * game over.
	 *                         Game over when snake crosses the screen boundary
	 * or bites its body. */
	public int move(String direction) {
		int[] head = snake.getFirst();
		int a = head[0];
		int b = head[1];
		switch (direction) {
		case "U":
			a--;
			if (a < 0)
				return -1;
			break;
		case "D":
			a++;
			if (a == h)
				return -1;
			break;
		case "L":
			b--;
			if (b < 0)
				return -1;
			break;
		case "R":
			b++;
			if (b == w)
				return -1;
			break;
		default:
			break;
		}
		// eat food
		if (cnt < food.length && a == food[cnt][0] && b == food[cnt][1]) {
			snake.addFirst(new int[] {a, b});
			board[a][b] = BODY;
			cnt++;
			return cnt;
		}
		// eat self
		int[] tail = snake.pollLast();
		board[tail[0]][tail[1]] = EMPTY;
		if (board[a][b] == BODY)
			return -1;

		snake.addFirst(new int[] {a, b});
		board[a][b] = BODY;
		return cnt;
	}
}

public class Solution {

	/** Ctrl + C starts here **/

	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		System.out.println("");
	}
}
