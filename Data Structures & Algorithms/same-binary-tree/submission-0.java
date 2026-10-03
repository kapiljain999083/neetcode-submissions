class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }

    boolean isSame(TreeNode a, TreeNode b){
        if(a==null && b==null) return true;
        if((a==null && b !=null) || (a!=null && b==null) 
        || (a.val!=b.val)) return false;
        boolean left = isSame(a.left, b.left);
        boolean right = isSame(a.right, b.right);
        return left && right;
    }
}