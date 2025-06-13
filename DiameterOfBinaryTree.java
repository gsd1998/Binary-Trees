package interviewQA.Trees.BinaryTrees;

public class DiameterOfBinaryTree {
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return dia;
    }
    public int diameter(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = diameter(root.left);
        int r = diameter(root.right);
        dia = Math.max(dia, l+r);
        return 1 + Math.max(l,r);
    }
}
