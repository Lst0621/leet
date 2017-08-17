package org.lst.leet.structure;
public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
		next = null;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		ListNode node = this;
		sb.append(val);
		while(node.next!=null){
			node = node.next;
			sb.append(" -->  ");
			sb.append(node.val);
		}
		return sb.toString();
	}
}
