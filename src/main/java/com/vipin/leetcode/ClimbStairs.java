/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipin.leetcode;

/**
 *
 * @author Vipin
 * link - https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbStairs {
    /*
     * Think of this as the sliding window problem
     * n - number of steps to climb
     * m - number of steps that can be taken at a time
     */
    public int climbStairs(int n, int m) {
        int res[] = new int[n + 1];
        int temp = 0;
        res[0] = 1;

        for(int i = 1; i <= n; i++) {
            int s = i - m - 1;
            int e = i - 1;
           
            if (s >= 0) {
               temp -= res[s];
            }
           
            temp += res[e];
            res[i] = temp;
        }
        
        return res[n];
    }
}
