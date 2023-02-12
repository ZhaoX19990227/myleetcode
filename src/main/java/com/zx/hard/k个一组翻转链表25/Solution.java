package com.zx.hard.k个一组翻转链表25;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode firstHead = head;
        ListNode firstTail = head;
        for (int i = 0; i < k - 1; i++) {
            firstTail = firstTail.next;
            if (firstTail == null) return firstHead;
        }
        ListNode secondHead = firstTail.next;
        //断开 视为整体进行反转
        firstTail.next = null;
        reverse(firstHead);
        //第一部分反转后  递归进行反转 与前面的连接
        firstHead.next = reverseKGroup(secondHead, k);
        return firstTail;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        //多个节点
        ListNode newNode = reverse(next);
        next.next = head;
        head.next = null;
        return newNode;
    }
}