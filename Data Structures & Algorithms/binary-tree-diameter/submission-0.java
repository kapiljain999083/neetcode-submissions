
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root ==null) return 0;
        int curr = height(root.left) + height(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(curr, Math.max(right, left));
    }

    int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
