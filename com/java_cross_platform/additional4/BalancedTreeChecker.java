// Task 2: Implement a function to check if a tree is balanced.For the purposes of this question, a balanced tree is defined to
// be a tree such that no two leaf nodes differ in distance from the root by more than one.

package com.java_cross_platform.additional4;

public class BalancedTreeChecker {

    // Find the height of each subtree, if the difference between the left subtree
    // and the right subtree is more than 1 then return False else return True

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is balanced
        }

        // Calculate the height of the left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Check if the tree is balanced and recurse on left and right subtrees
        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the height of the subtree
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // Return the maximum height of the left and right subtrees plus one (current
        // node)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

        // // Example # 1
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);

        // // Example # 2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        boolean result = isBalanced(root);

        if (result) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}