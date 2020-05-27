package com.alex.link;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个链表的第一个公共节点
 *
 * 原题地址
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class IntersectionNode {

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode headATemp1 = new ListNode(1);
        headA.next=headATemp1;

        ListNode headB = new ListNode(5);
        ListNode headBTemp0 = new ListNode(0);
        ListNode headBTemp1 = new ListNode(1);
        headB.next=headBTemp0;
        headBTemp0.next=headBTemp1;

        ListNode common8 = new ListNode(8);
        ListNode common4 = new ListNode(4);
        ListNode common5 = new ListNode(5);
        headATemp1.next=common8;
        headBTemp1.next=common8;
        common8.next=common4;
        common4.next=common5;


        ListNode result = getIntersectionNode2(headA, headB);
        System.out.println(result);
    }



    private static ListNode buildListNode1() {
        ListNode result = new ListNode(4);
        ListNode temp1 = new ListNode(1);
        ListNode temp8 = new ListNode(8);
        ListNode temp4 = new ListNode(4);
        ListNode temp5 = new ListNode(5);

        temp4.next=temp5;
        temp8.next=temp4;
        temp1.next=temp8;
        result.next=temp1;

        return result;
    }

    public static ListNode buildListNode2() {
        ListNode result = new ListNode(5);
        ListNode temp0 = new ListNode(0);
        ListNode temp1 = new ListNode(1);
        ListNode temp8 = new ListNode(8);
        ListNode temp4 = new ListNode(4);
        ListNode temp5 = new ListNode(5);

        temp4.next=temp5;
        temp8.next=temp4;
        temp1.next=temp8;
        temp0.next=temp1;
        result.next=temp0;
        return result;
    }


    /**
     * 第一种做法，将一条链表的数据放入到一个list中。然后对另外一条链表进行循环check
     *
     * 执行用时 :
     * 1391 ms
     * , 在所有 Java 提交中击败了
     * 5.04%
     * 的用户
     * 内存消耗 :
     * 42.4 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(null == headA || null == headB) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode temp = headA;

        do {
            if(temp != null) {
                list.add(temp);
                temp = temp.next;
            }
        } while (temp != null);

        temp = headB;
        do {
            if(list.contains(temp)) {
                return temp;
            }

            temp = temp.next;
        } while (temp != null);

        return null;
    }

    /**
     * 第二种方法，使用双指针完成
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            if(pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }

            if(pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }

        }

        return pA;
    }

        static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
