//url: https://leetcode.com/problems/symmetric-tree/description/
package sysmTree;

import org.lst.leet.structure.TreeNode;

import java.util.LinkedList;

public class Solution {

	/** Ctrl + C starts here **/
	public boolean isSymmetric(TreeNode root) {
		return isSymmetricV2(root);

	}
	//beat 10.75
	private boolean isSymmetricV2(TreeNode root) {
		if (root==null) return true;
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root.left);
		list.add(root.right);
		return isListSymV2(list);
	}
	private boolean isListSymV2(LinkedList<TreeNode> list){
		while(list.size()>0) {
			TreeNode head = list.pollFirst();
			TreeNode tail = list.pollFirst();
			if (head==null) {
				if (tail != null) {
					return false;
				}
			}
			else {
				if(tail==null) {
					return false;
				}
				if(head.val!=tail.val) {
					return false;
				}

				list.addLast(head.right);
				list.addLast(tail.left);
				list.addLast(head.left);
				list.addLast(tail.right);
			}
		}
		return true;
	}

	/** Ctrl + C ends here **/

	//beat 3.88
	private boolean isSymmetricV1(TreeNode root) {
		if (root==null) return true;
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root.left);
		list.add(root.right);
		return isListSym(list);
	}
	private boolean isListSym(LinkedList<TreeNode> list){
		if(list.size()%2==1)
			return false;

		TreeNode head;
		TreeNode tail;
		LinkedList<TreeNode> deep = new LinkedList<>();
		while(list.size()>0) {
			head = list.pollFirst();
			tail = list.pollLast();
			if (head==null) {
				if (tail != null) {
					return false;
				}
			}
			else {
				if(tail==null) {
					return false;
				}
				if(head.val!=tail.val) {
					return false;
				}
				//fixme
				deep.addFirst(head.right);
				deep.addFirst(head.left);
				deep.addLast(tail.left);
				deep.addLast(tail.right);
			}
		}
		if(deep.size()==0) return true;
		return isListSym(deep);

	}




	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
	}
}
