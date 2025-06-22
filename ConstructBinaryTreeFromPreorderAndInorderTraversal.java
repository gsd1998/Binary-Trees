package interviewQA.Trees.BinaryTrees;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] pre, int[] in) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++){
            map.put(in[i], i);
        }
        return createBinaryTree(pre, 0, pre.length -1, in, 0, in.length -1, map);
    }

    public TreeNode createBinaryTree(int[] pre, int ps, int pe, int[] in, int is, int ie, HashMap<Integer,Integer> map){
        if(ps > pe || is > ie)
            return null;

        TreeNode root = new TreeNode(pre[ps]);
        int inIndex = map.get(root.val);
        int numsLeft = inIndex - is;
        root.left = createBinaryTree(pre, ps + 1, ps + numsLeft, in, is, inIndex - 1, map);
        root.right = createBinaryTree(pre, ps + numsLeft + 1, pe, in, inIndex + 1, ie, map);
        return root;
    }
}
