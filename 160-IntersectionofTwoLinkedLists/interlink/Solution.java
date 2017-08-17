// url:
// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
/**
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                      ↗
 *   B:     b1 → b2 → b3
 *
 *  If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure
 * after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */

package interlink;
import org.lst.leet.factory.*;
import org.lst.leet.structure.*;

public class Solution {

	/** Ctrl + C starts here **/

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		return null;
	}

	/** Ctrl + V code ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		ListNode listA = NodeListFac.genList(5);
		ListNode listB = NodeListFac.genList(4, listA);
		ListNode listC = NodeListFac.genList(3, listA);
		System.out.println(listA);
		System.out.println(listB);
		System.out.println(listC);
		System.out.println(getIntersectionNode(listB, listC));
	}
}
