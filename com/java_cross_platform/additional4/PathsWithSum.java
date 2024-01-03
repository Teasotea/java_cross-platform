// Task 3: You are given a binarytree in which each node contains a value. Design an algorithm
// to print all paths which sum up to that value. Note that it can be any path in the tree
// - it does not have to start at the root.

package com.java_cross_platform.additional4;

import java.util.ArrayList;
import java.util.List;

public class PathsWithSum {

    public static List<List<Integer>> findPaths(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsHelper(root, targetSum, currentPath, result);
        return result;
    }

    private static void findPathsHelper(TreeNode node, int targetSum, List<Integer> currentPath,
            List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // Add the current node to the current path
        currentPath.add(node.val);

        // Check if the current path sums up to the targetSum
        int sum = 0;
        for (int i = currentPath.size() - 1; i >= 0; i--) {
            sum += currentPath.get(i);
            if (sum == targetSum) {
                result.add(new ArrayList<>(currentPath.subList(i, currentPath.size())));
            }
        }

        // Recursively explore the left and right subtrees
        findPathsHelper(node.left, targetSum, currentPath, result);
        findPathsHelper(node.right, targetSum, currentPath, result);

        // Backtrack: remove the current node from the current path
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {

        // // Example # 1
        // TreeNode root = new TreeNode(10);
        // root.left = new TreeNode(5);
        // root.right = new TreeNode(-3);
        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(2);
        // root.right.right = new TreeNode(11);
        // root.left.left.left = new TreeNode(3);
        // root.left.left.right = new TreeNode(-2);
        // root.left.right.right = new TreeNode(1);
        // int targetSum = 8;

        // Example # 2
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;

        List<List<Integer>> paths = findPaths(root, targetSum);

        // Print the paths
        System.out.println("Paths with sum " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}