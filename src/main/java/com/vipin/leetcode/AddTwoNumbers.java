/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipin.leetcode;

/**
 *
 * @author Vipin
 * link - https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean track = true;
        int carry = 0;
        ListNode start = null;
        ListNode result = null;
        
        while (track) {
            int l1_num = (null == l1 ? 0 : l1.val);
            int l2_num = (null == l2 ? 0 : l2.val);
            
            int sum = l1_num + l2_num + carry;
            carry = (sum < 10 ? 0 : 1);
            
            if (null == result) {
                result = new ListNode(sum % 10);
                start = result;
            
            } else {
                result.next = new ListNode(sum % 10);
                result = result.next;                
            }
            
            if (null != l1) l1 = l1.next;
            if (null != l2) l2 = l2.next;
            
            if (null == l1 && null == l2) track = false;
        }
        
        return start;
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
