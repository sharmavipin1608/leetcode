/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipin.leetcode;

/**
 *
 * @author Vipin
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l1_start = l1;
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(4);
        
        ListNode l2 = new ListNode(1);
        ListNode l2_start = l2;
        l2.next = new ListNode(3);
        l2 = l2.next;
        l2.next = new ListNode(4);
        
        ListNode result = mergeTwoLists(l1_start, l2_start);
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode start = node;
        
        while (l1 != null || l2 != null) {
            System.out.println("l1 : " + l1.val);
            System.out.println("l2 : " + l2.val);
            
            node.next = new ListNode(Math.min(l1.val, l2.val));
            node = node.next;
            
            if (l1.val < l2.val) {
                l1 = l1.next;
            
            } else {
                l2 = l2.next;
            }
        }
        
        if (null == l1 && null != l2) {
            node.next = l2;
        
        } else if (null == l2 && null != l1) {
            node.next = l1;
        }
        
        return start.next;
    }
}
