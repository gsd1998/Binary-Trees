package interviewQA.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    public void postorder(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    /********* Iterative Single Stack **********/
    public List<Integer> postorderTraversalSingleStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        if(root == null)
            return list;
        TreeNode node = root;
        st1.push(node);
        while(!st1.isEmpty()){
            node = st1.pop();
            st2.push(node);
            if(node.left != null){
                st1.push(node.left);
            }
            if(node.right != null){
                st1.push(node.right);
            }
        }
        while(!st2.isEmpty())
            list.add(st2.pop().val);
        return list;
    }

    /********* Iterative Two Stacks **********/
    public List<Integer> postorderTraversalTwoStacks(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root == null)
            return list;
        TreeNode curr = root;
        TreeNode temp = null;
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    list.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        list.add(temp.val);
                    }
                }else{
                    curr = temp;
                }
            }
        }
        return list;
    }

}
