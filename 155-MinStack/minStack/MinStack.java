//url: https://leetcode.com/problems/min-stack/description/
package minStack;


import java.util.Stack;

public class MinStack {

	/** initialize your data structure here. */
	private Stack<Integer> stack;
	private Stack<Integer> trace;
	private int min;
	public MinStack() {
		stack = new Stack<>();
		trace = new Stack<>();
		min = Integer.MAX_VALUE;

	}

	public void push(int x) {
		stack.push(x);
		if(min>=x) {
			min = x;
			trace.push(min);
		}

	}

	public void pop() {
		int num = stack.pop();
		if(num==min) {
			trace.pop();
			if (stack.empty()) {
				min = Integer.MAX_VALUE;
			} else
				min = trace.peek();
		}

	}

	public int top() {
		return stack.peek();

	}

	public int getMin() {
		return min;

	}

	public static void main(String[] args) {
		test();

	}
	public static void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());


	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */