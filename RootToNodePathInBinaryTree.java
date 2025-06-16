package interviewQA.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePathInBinaryTree {

    static boolean flag = false;
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        int givenVal = 7;
        List<Integer> list = new ArrayList<>();
        rootToNode(root, list, givenVal);
        System.out.println(list); // [1, 2, 5, 7]
    }

    public static void rootToNode(TreeNode node, List<Integer> list, int givenVal){
        if(node == null){
            return;
        }
        list.add(node.val);
        if(node.val == givenVal){
            flag = true;
            return;
        }
        rootToNode(node.left, list, givenVal);
        if(flag) return;
        rootToNode(node.right, list, givenVal);
        if(flag) return;
        list.remove(list.size()-1);
    }
}


