/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vipin
 * link - https://leetcode.com/problems/two-sum/solution/
 */
public class TwoSum {
    //BRUTE FORCE
    public int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }   
            }            
        }
        
        return new int[] {0,1};
    }
    
    //USING HASHMAP
    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {            
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }
            map.put(nums[i], i);
        }
        
        return null;
    }
}
