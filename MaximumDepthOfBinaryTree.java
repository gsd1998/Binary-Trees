package interviewQA.Trees.BinaryTrees;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return depth(root);
    }
    public int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        return 1 + Math.max(l,r);
    }
}
