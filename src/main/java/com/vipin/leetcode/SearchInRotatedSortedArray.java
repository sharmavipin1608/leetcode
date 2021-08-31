/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipin.leetcode;

/**
 *
 * @author Vipin
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[] {1,4};
        System.out.println(findPivot(nums, 0, (nums.length-1)));
    }
    
    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        
        if (-1 == pivot) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        
        if (nums[pivot] == target) return pivot;
        
        if (nums[0] <= target) return binarySearch(nums, 0, pivot - 1, target);
        
        return binarySearch(nums, pivot, nums.length - 1, target);
    }
    
    public static int binarySearch(int[] nums, int start, int end, int target) {
        if (end < start) return -1;
        
        int mid = (start + end) / 2;
        
        if (target == nums[mid]) return mid;
        if (target < nums[mid]) return binarySearch(nums, start, mid - 1, target);
        
        return binarySearch(nums, mid + 1, end, target);
    }
    
    public static int findPivot(int[] nums, int start, int end) {
        if (nums[start] < nums[end] || start == end) {
            return -1;
        }
        
        if (end - start == 1 && nums[end] < nums[start]) {
            return end;
        }
        
        int left = findPivot(nums, start, (start+end)/2);
        int right = findPivot(nums, (start+end)/2, end);
        
        return Math.max(left, right);
    }
}
