/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipin.leetcode;

/**
 *
 * @author Vipin
 * link - https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    public int majorityElement(int[] a) {
        int maj_index = 0, count = 1;
        int i;
        
        for (i = 1; i < a.length; i++) {
            if (a[maj_index] == a[i]) count++;
            
            else count--;
            
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        
        return a[maj_index];
    }
}
