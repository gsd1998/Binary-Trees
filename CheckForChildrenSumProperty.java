package interviewQA.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class CheckForChildrenSumProperty {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        inorderTraversal(root);//6 5 7 2 4 3 0 1 8
        System.out.println();
        childSum(root);
        inorderTraversal(root);//6 17 7 11 4 25 0 8 8
    }
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
    public static void childSum(TreeNode root) {
        if(root == null){
            return;
        }
        int child = 0;
        if(root.left != null)
            child = child + root.left.val;
        if(root.right != null)
            child = child + root.right.val;
        if(child >= root.val){
            root.val = child;
        }else{
            if(root.left != null){
                root.left.val = root.val;
            }
            if(root.right != null){
                root.right.val = root.val;
            }
        }
        childSum(root.left);
        childSum(root.right);
        int total = 0;
        if(root.left != null)
            total = total + root.left.val;
        if(root.right != null)
            total = total + root.right.val;
        if(root.left != null || root.right != null){
            root.val = total;
        }
    }
}
