package com.alex.link;

/**
 * description:
 * author: alex
 * date: 2019/12/31
 */
public class Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);

        ListNode listNode2 = new ListNode(2);
        listNode1.next=listNode2;
        ListNode listNode4 = new ListNode(4);
        listNode2.next=listNode4;


        ListNode rightNode1 = new ListNode(1);
        ListNode rightNode3 = new ListNode(1);
        rightNode1.next=rightNode3;
        ListNode rightNode4 = new ListNode(1);
        rightNode3.next=rightNode4;

        mergeTwoLists(listNode1, rightNode1);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
