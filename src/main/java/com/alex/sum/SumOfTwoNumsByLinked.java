package com.alex.sum;

/**
 * 以链表的方式求两个数的和
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例:            输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *                  输出：7 -> 0 -> 8
 *                  原因：342 + 465 = 807
 *
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 *
 * 如果说链表是一个正序链表呢？ 这样加一个转换就行了，正序转倒叙
 */
public class SumOfTwoNumsByLinked {

    public static LinkNode addTwoNumbers(LinkNode l1, LinkNode l2) {
        LinkNode result = new LinkNode(0);

        LinkNode l1_next = l1, l2_next = l2, curr = result;
        int carry  = 0; // 这个是指的是否有进位。
        while (l1_next != null || l2_next != null) {
            int x = l1_next != null? l1_next.val : 0;
            int y = l2_next != null? l2_next.val : 0;
            int sum = carry + x + y;
            // 如果有进位，需要把需要进位的数给到carry
            carry = sum / 10;
            // 设置链表信息
            curr.next = new LinkNode(sum % 10);
            curr = curr.next;
            if (l1_next != null)
                l1_next = l1_next.next;
            if(l2_next != null)
                l2_next = l2_next.next;
        }
        if(carry > 0) {
            curr.next = new LinkNode(carry);
        }
        return result.next;
    }


    public static void main(String[] args) {
        /**
         * 这里先做一个简化操作，就是将数字转换为倒叙联表的方法先省略掉
         */
        LinkNode l1 = new LinkNode(2);
        LinkNode l1_4 = new LinkNode(4);
        LinkNode l1_3 = new LinkNode(3);
        LinkNode l1_5 = new LinkNode(5);
        l1.setNext(l1_4);
        l1_4.setNext(l1_3);
        l1_3.setNext(l1_5);

        LinkNode l2 = new LinkNode(5);
        LinkNode l2_6 = new LinkNode(6);
        LinkNode l2_4 = new LinkNode(4);
        l2.setNext(l2_6);
        l2_6.setNext(l2_4);

        LinkNode result = addTwoNumbers(l1, l2);
        if(result != null) {
            do {
                System.out.print(result.val);
                result = result.next;
            } while (result != null);
            System.out.println();
        }
    }
}

class LinkNode {
    int val;
    LinkNode next;

    LinkNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }
}
