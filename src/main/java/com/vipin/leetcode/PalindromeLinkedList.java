/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipin.leetcode;

/**
 *
 * @author Vipin
 * link - https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode start = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(1);
        
        System.out.println(isPalindrome(start));
    }
    
    public static boolean isPalindrome(ListNode head) {
        ListNode current = head;
        int size = 0;
        
        while (current != null) {
            current = current.next;
            size++;
        }
        
        if (size == 0) return true;
        
        current = head;
        
        for (int i = 0; i < size/2; i++) current = current.next;
        if (size % 2 != 0) current = current.next;
            
        ListNode check = reverse(current);

        return compare(head, check);
    }
    
    private static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    private static boolean compare(ListNode front, ListNode back) {               
        while (null != front && null != back) {
            if (front.val != back.val) {
                return false;
            }
            
            front = front.next;
            back = back.next;
        }
        
        return true;
    }
    
    private static void printList(ListNode node) {
        ListNode head = node;
        
        while (null != node) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }
}
