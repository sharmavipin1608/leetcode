/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipin.leetcode;

import java.util.*;

/**
 *
 * @author Vipin
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "zwnigfunjwz";
        String str1 = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring_1(str1));
    }
    
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int curr = 0;
        int boundary = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                max = (curr < max ? max : curr);
                boundary = Math.max(boundary, map.get(s.charAt(i)));
                curr = i - boundary - 1;
            }
            
            map.put(s.charAt(i), i);
            curr++;            
        }
        
        return (max < curr ? curr : max);
    }
    
    //Moving window
    public static int lengthOfLongestSubstring_1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int curr = 0;
        int boundary = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                curr = Math.max(curr, map.get(s.charAt(i)) + 1) ;
                System.out.println("i : " + i + ", curr : " + curr);
            }
            
            map.put(s.charAt(i), i);
            max = Math.max(max, i - curr + 1);   
            System.out.println("i : " + i + ", max : " + max);
        }
        
        return max;
    }
}
