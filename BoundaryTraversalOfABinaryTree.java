package interviewQA.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversalOfABinaryTree {
    public static void main(String[] args) {

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);*/

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);*/

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(4);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> result1 = traverse(root, list1);
        List<Integer> result2 = traverseBoundary(root, list2);

        System.out.println("Boundary Traversal: " + result1); //[1, 4, 3, 2]
        System.out.println("Boundary Traversal: " + result2); //[1, 4, 3, 2]
    }

    public static List<Integer> traverse(TreeNode root, List<Integer> list){
        TreeNode node = root;
        TreeNode left = root.left;
        TreeNode right = root.right;

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(node);
        boolean rightSubTreeReached = false;
        while(!st1.isEmpty()){
            node = st1.pop();
            if(right == node || rightSubTreeReached){
                rightSubTreeReached = true;
                st2.push(node);
                if(node.left != null){
                    st1.push(node.left);
                }
                if(node.right != null){
                    st1.push(node.right);
                }
            }else{
                if(node.right != null){
                    st1.push(node.right);
                }
                if(node.left != null){
                    st1.push(node.left);
                }
                list.add(node.val);
            }
        }
        while(!st2.isEmpty()){
            list.add(st2.pop().val);
        }
        return list;
    }


    /* Striver's approach */
    public static List<Integer> traverseBoundary(TreeNode root, List<Integer> ans){
        if (root == null) {
            return ans;
        }
        if(!isLeafNode(root)){
            ans.add(root.val);
        }
        addLeftBoundary(root, ans);
        addLeafNodes(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }

    private static void addLeafNodes(TreeNode root, List<Integer> ans) {
        if(isLeafNode(root)){
            ans.add(root.val);
            return;
        }
        if(root.left != null){
            addLeafNodes(root.left, ans);
        }
        if(root.right != null){
            addLeafNodes(root.right, ans);
        }
    }

    private static void addRightBoundary(TreeNode root, List<Integer> ans) {
        TreeNode curr = root.right;
        Stack<Integer> stack = new Stack<>();
        while(curr != null){
            if(!isLeafNode(curr))
                stack.push(curr.val);
            if(curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
    }

    private static void addLeftBoundary(TreeNode root, List<Integer> ans) {
        TreeNode curr = root.left;
        while(curr != null){
            if(!isLeafNode(curr))
                ans.add(curr.val);
            if(curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    public static boolean isLeafNode(TreeNode node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }

}
