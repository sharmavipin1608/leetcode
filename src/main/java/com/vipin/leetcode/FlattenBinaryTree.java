package com.vipin.leetcode;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vipin
 * link - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeNode.init();
        flatten(node);
        
        while (null != node) {
            System.out.println(node.val + ", " + (null == node.left ? null : "invalid"));
            node = node.right;
        }
    }
    
    public static void flatten(TreeNode root) {
        List<TreeNode> result = new ArrayList();
        preOrderTraversal(root, result);
        
        for (int i = 0; i < result.size() - 1; i++) {
            result.get(i).right = result.get(i + 1);
            result.get(i).left = null;           
        }
    }
    
    private static void preOrderTraversal(TreeNode node, List<TreeNode> result) {
        if (null == node) return;
        
        result.add(node);
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
    }
}
