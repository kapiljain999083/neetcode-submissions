/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        return call(root);
    }

 public TreeNode call(TreeNode root) {
        if(root==null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right=left;
        root.left=right;
        call(root.left);
        call(root.right);
        return root;
    }
}
