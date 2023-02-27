package com.zx.easy.删除排序链表中的重复元素83;

import java.util.concurrent.locks.ReentrantLock;

public class ListNode {
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

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }
}