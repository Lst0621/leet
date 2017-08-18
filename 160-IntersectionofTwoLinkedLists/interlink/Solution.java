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

	private ListNode tail = null;
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		int sum1 = reverse(headA);
		ListNode endingA = tail;
		//		System.out.println(sum1);
		//		System.out.println(endingA);

		int sum2 = reverse(headB);
		ListNode endingB = tail;
		//		System.out.println(sum2);
		//		System.out.println(endingB);

		if (endingB != headA) {
			reverse(endingA);
			reverse(endingB);
			return null;
		}

		int sum3 = reverse(endingA);
		if (sum1 < sum3) {
			int a = (sum1 + sum2 - sum3) / 2;
			ListNode res = headA;
			while (a > 0) {
				res = res.next;
				a--;
			}
			return res;
		} else {
			int b = (sum3 + sum2 - sum1) / 2;
			ListNode res = headB;
			while (b > 0) {
				res = res.next;
				b--;
			}
			return res;
		}
	}

	private int reverse(ListNode head) {
		int cnt = 0;
		ListNode temp = null;
		ListNode nodeA = head;
		ListNode nodeB = nodeA.next;
		while (nodeB != null) {
			nodeA.next = temp;
			temp = nodeA;
			nodeA = nodeB;
			nodeB = nodeB.next;
			cnt++;
		}
		nodeA.next = temp;
		tail = nodeA;
		return cnt;
	}

	/** Ctrl + C ends here **/

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
