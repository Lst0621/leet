package org.lst.leet.factory;
import org.lst.leet.structure.ListNode;


/**
 * Created by lst2016 on 8/17/17.
 */
public class NodeListFac {
    public static ListNode genList(int num,ListNode another){
        if (num<=0) return null;
        ListNode head = null;
        ListNode tail = another;
        int temp = 0;
        while(temp!=num) {
           head = new ListNode(temp);
           head.next = tail;
           tail = head;
           temp++;
        }
        return head;
    }
    public static ListNode genList(int num){
        return genList(num,null);
    }


}
