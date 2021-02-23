package com.sceon.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

/**
 * @author shichenchong@inspur.com
 * date   2020/7/28 14:41
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class LeetCode01 {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(3);
        //l2.next.next.next = new ListNode(3);
        ListNode newNode = addTwoNumbers(l1, l2);
        System.out.println(newNode.val + "" + newNode.next.val + "" + newNode.next.next.val + "" + newNode.next.next.next.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, null);
    }

    public static ListNode add(ListNode l1, ListNode l2, ListNode prev) {
        /**
         * 使用递归的方法，增加一个类似于前置节点的节点，最开始让这个节点为空
         *
         */
        ListNode next1 = null;
        ListNode next2 = null;
        int val1 = 0;
        int val2 = 0;
        // 5 -> 6 -> 7
        if (l1 != null) {
            val1 = l1.val; // 7
            next1 = l1.next; // 6 7 null
        }
        // 5 -> 4 -> 3
        if (l2 != null) {
            val2 = l2.val;// 3
            next2 = l2.next; //4 3 null
        }
        ListNode newNode = new ListNode(val1 + val2); // 10 10 10
        // 最开始为空 10
        if (prev != null) {
            if (prev.val >= 10) {
                prev.val %= 10; // 0 1
                newNode.val += 1; // 11 11
            }
        }
        // 6 4 10   7 3 11
        if (next1 != null || next2 != null) {
            newNode.next = add(next1, next2, newNode);
        } else if (newNode.val >= 10) { // null null 11
            newNode.next = add(next1, next2, newNode);
        }
        return newNode;
    }

}
