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
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = Arrays.asList(root);
        
        while (isLevelValid(list)) {
            List<Integer> currentLevel = new ArrayList<>();
            for (TreeNode node : list) {
                if (null != node) currentLevel.add(node.val);
            }
            
            result.add(currentLevel);
            
            list = getNextLevel(list);
        }
        
        return result;
    }
    
    private boolean isLevelValid(List<TreeNode> list) {
        for (TreeNode node : list) {
            if (null != node) return true;
        }
        
        return false;
    }
    
    private List<TreeNode> getNextLevel(List<TreeNode> list) {
        List<TreeNode> result = new ArrayList<>();
        for (TreeNode node : list) {
            if (null == node) {
                result.add(null);
                result.add(null);
            
            } else {
                result.add(node.left);
                result.add(node.right);    
            }            
        }
        
        return result;
    }
    
    // ----------------------------------------------------------------
    
    public List<List<Integer>> levelOrder_1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        treeTraversal(root, 1, map);
        
        for (int i = 1; i <= map.size(); i++) {
            result.add(map.get(i));
        }
        
        return result;
    }
    
    private void treeTraversal(TreeNode node, int level, Map<Integer, List<Integer>> map) {
        if (null == node) return;
        
        map.computeIfAbsent(level, (ignore) -> new ArrayList<Integer>());
        map.get(level).add(node.val);
        
        treeTraversal(node.left, level + 1, map);
        treeTraversal(node.right, level + 1, map);
    }
    
    // ----------------------------------------------------------------
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
