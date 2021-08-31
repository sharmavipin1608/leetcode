/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipin.leetcode;

/**
 *
 * @author Vipin
 * link - https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(-3);
        Result res = new Result();
        traverse(node, res);
        
        System.out.println(res.val);
    }
    
    public static int traverse(TreeNode root, Result res) {
        if (null == root) return 0;
        
        int sLeft = traverse(root.left, res);
        int sRight = traverse(root.right, res);
        
        int max_single = Math.max(Math.max(sLeft, sRight) + root.val, root.val);
        int max_top = Math.max(max_single, root.val + sLeft + sRight);
        
        res.val = Math.max(max_top, res.val);
        
        return max_single;
    }
    
    private static class Result {
        Integer val = Integer.MIN_VALUE;
    }
}
