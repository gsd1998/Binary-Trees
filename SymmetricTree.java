package interviewQA.Trees.BinaryTrees;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        return recurse(root.left, root.right);
    }

    public boolean recurse(TreeNode leftSubTree, TreeNode rightSubTree) {
        if(leftSubTree == null && rightSubTree == null){
            return true;
        }
        if(leftSubTree == null || rightSubTree == null){
            return false;
        }
        if(leftSubTree.val != rightSubTree.val){
            return false;
        }
        return recurse(leftSubTree.left, rightSubTree.right) && recurse(leftSubTree.right, rightSubTree.left);
    }
}
