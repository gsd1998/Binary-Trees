package interviewQA.Trees.BinaryTrees;

import java.util.HashMap;

public class ConstructBinaryTreeFromPostorderAndInorderTraversal {
    public TreeNode buildTree(int[] in, int[] post) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++){
            map.put(in[i], i);
        }
        return createBinaryTree(post, 0, post.length -1, in, 0, in.length -1, map);
    }
    public TreeNode createBinaryTree(int[] post, int ps, int pe, int[] in, int is, int ie, HashMap<Integer,Integer> map){
        if(ps > pe || is > ie)
            return null;

        TreeNode root = new TreeNode(post[pe]);
        int inIndex = map.get(root.val);
        int numsRight = ie - inIndex;
        root.left = createBinaryTree(post, ps, pe - numsRight - 1, in, is, inIndex - 1, map);
        root.right = createBinaryTree(post, pe - numsRight, pe - 1, in, inIndex + 1, ie, map);
        return root;
    }
}
