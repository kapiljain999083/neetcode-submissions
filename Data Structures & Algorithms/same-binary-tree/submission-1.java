class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }

    public boolean isSame(TreeNode a, TreeNode b){
        if(a==null && b==null) return true;
        if((a==null && b !=null) || (a!=null && b==null) || (a.val!=b.val)) return false;
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}