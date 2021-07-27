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
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        
        for (int i = 0; i < n; i++) {
            if (second.next == null) {
                if (i == n - 1) {
                    return head = head.next;
                }
            }
            
            second = second.next;
        }
        
        while (second.next != null) {
            second = second.next;
            first = first.next;
        }
        
        first.next = first.next.next;
        return head;
    }
}
