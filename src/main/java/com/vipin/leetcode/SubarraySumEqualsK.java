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
 * link - https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 1};
        System.out.println(subarraySum(arr, 2));
    }
    
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int curr = 0;
        
        for (int i = 0; i < nums.length; i++) {
            curr = curr + nums[i];
            
            if (curr == k) result++;
            
            if (map.containsKey(curr - k)) {
                result = result + map.get(curr - k);
            }
            
            if (null != map.get(curr)) {
                map.put(curr, map.get(curr) + 1);
            } else {
                map.put(curr, 1);
            }
        }
        
        return result;
    }
}
