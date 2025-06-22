package interviewQA.Trees.BinaryTrees;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int l = countNodes(root.left);
        int r = countNodes(root.right);
        return l+r+1;
    }

    //O(logN)^2 solution using 2^h-1 concept where h is the height of a complete binary tree
    public int countNodesOptimised(TreeNode root) {
        if(root == null)
            return 0;

        int l = findLeftTreeHeight(root);
        int r = findRightTreeHeight(root);
        if(l == r){
            return (2<<l) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int findLeftTreeHeight(TreeNode root){
        int count = 0;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }

    public int findRightTreeHeight(TreeNode root){
        int count = 0;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }


}
