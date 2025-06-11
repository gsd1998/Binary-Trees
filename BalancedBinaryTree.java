package interviewQA.Trees.BinaryTrees;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        TreeNode node = root;
        int ans = balanced(root);
        if(ans == -1){
            return false;
        }
        return true;
    }

    public int balanced(TreeNode node) {
        if(node == null){
            return 0;
        }
        int l = balanced(node.left);
        if(l == -1){
            return -1;
        }
        int r = balanced(node.right);
        if(r == -1){
            return -1;
        }
        if(Math.abs(l-r) > 1){
            return -1;
        }
        return 1+ Math.max(l,r);
    }
}
