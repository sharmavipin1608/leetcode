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
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = new int[] {2,3,5};
        List<List<Integer>> result = combinationSum(candidates, 8);
        
        for (int i = 0; i < result.size(); i++) {
 
            System.out.print("(");
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.print(") ");
        }
    }
    
    public static List<List<Integer>> combinationSum_1(int[] candidates, int target) {
        Map<Integer, List<Integer>> records = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        
        for (int num : candidates) {
            input.add(num);
        }

        findCombinations_1(result, input, target, 0, new ArrayList<>());
        
        return result;
    }
    
    private static void findCombinations_1(List<List<Integer>> result,
                                  List<Integer> input,    
                                  int target,
                                  int index,
                                  List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
 
        for (int i = index; i < input.size(); i++) {
            
            if ((target - input.get(i)) >= 0) {
                temp.add(input.get(i));
                findCombinations_1(result, input, target - input.get(i), i, temp);
                temp.remove(input.get(i));
            }
        }                         
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer, List<Integer>> records = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        findCombinations(result, candidates, target, 0, new ArrayList<>());
        
        return result;
    }
    
    private static void findCombinations(List<List<Integer>> result,
                                         int[] input,    
                                         int target,
                                         int index,
                                         List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
 
        for (int i = index; i < input.length; i++) {
            System.out.println("b :" + i);
            if ((target - input[i]) >= 0) {
                temp.add(input[i]);
                findCombinations(result, input, target - input[i], i, temp);
                System.out.println("a :" + i);
                temp.remove(Integer.valueOf(input[i]));
            }
        }                         
    }
}
