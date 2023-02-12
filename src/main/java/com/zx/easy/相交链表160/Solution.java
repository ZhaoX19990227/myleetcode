package com.zx.easy.相交链表160;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode fast;
        ListNode slow;
        fast = headA;
        slow = headB;
        while (fast != slow) {
            fast = fast == null ? headA : fast.next;
            slow = slow == null ? headB : slow.next;
        }
        return fast;
    }
}