package interviewQA.Trees.BinaryTrees;

public class BinaryTreeMaximumPathSum {
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        TreeNode node = root;
        maxSum(node);
        return maxi;
    }

    public int maxSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = Math.max(0, maxSum(root.left));
        int r = Math.max(0, maxSum(root.right));
        maxi = Math.max(maxi, root.val + l + r);
        return root.val + Math.max(l,r);
    }
}
