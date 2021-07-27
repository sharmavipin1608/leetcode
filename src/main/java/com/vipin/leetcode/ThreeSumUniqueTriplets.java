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
 * link - https://leetcode.com/problems/3sum/
 */
public class ThreeSumUniqueTriplets {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);        
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = 0 - (nums[i] + nums[j]);
                
                if (map.containsKey(diff) && j < map.get(diff)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[map.get(diff)]);
                    Collections.sort(temp);
                    
                    if (!result.contains(temp)) result.add(temp);
                } 
            }            
        }
        
        return result;
    }
}
