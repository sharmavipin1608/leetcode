/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipin.leetcode;

/**
 *
 * @author Vipin
 * link - https://leetcode.com/problems/move-zeroes/submissions/
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = new int[] { 0,1,0,3,12 };
        moveZeroes(arr);
        
        for (int num : arr) {
            System.out.println(num);
        }
    }
    
    public static void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { 
                if(zeroIndex == -1) {
                    zeroIndex = i;
                }
            } else {
                if (zeroIndex != -1) {
                    moveZeroToEnd(nums, zeroIndex, i);
                    zeroIndex++;
                }
            }
        }
    }
    
    public static void moveZeroToEnd(int[] nums, int zeroIndex, int currIndex) {
        
        System.out.println("movezerotoend : " + zeroIndex + " : " + currIndex);
        int num = nums[currIndex];
        for (int i = zeroIndex; i < currIndex; i++) {
            printArray(nums);
            System.out.println("moving : " + i + " : " + nums[i] +  " : " + nums[i+1]);
            nums[i+1] = nums[i];
        }
        
        nums[zeroIndex] = num;
    }
    
    private static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(" : " + i);
        }
    }
}
