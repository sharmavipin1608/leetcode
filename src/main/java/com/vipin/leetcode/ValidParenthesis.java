/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipin.leetcode;

import java.util.Stack;

/**
 *
 * @author Vipin
 * link - https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
    
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if ('(' == str.charAt(i)
                || '{' == str.charAt(i)
                || '[' == str.charAt(i)) {
                stack.push(str.charAt(i));
            
            } else {
                System.out.println("matchingParenthesis : " + matchingParenthesis(str.charAt(i)));
                if (!stack.isEmpty()
                    && stack.peek() == matchingParenthesis(str.charAt(i))) {
                    stack.pop();
                
                } else {
                    return false;
                }
            }
        }
        
        return (stack.empty() ? true: false);
    }
    
    private static char matchingParenthesis(char c) {
        switch (c) {
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';
        }
        
        return 'a';
    }
}
