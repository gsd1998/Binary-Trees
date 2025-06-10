package interviewQA.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderInorderPostorderInOneTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        allInOneTraversal(root);
    }

    public static void allInOneTraversal(TreeNode root){
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pairs> st = new Stack<>();
        st.push(new Pairs(root,1));

        while(!st.isEmpty()) {
            Pairs pair = st.pop();
            if (pair.num == 1) {
                pair.num = pair.num + 1;
                st.push(new Pairs(pair.node, pair.num));
                preOrder.add(pair.node.val);
                if (pair.node.left != null) {
                    st.push(new Pairs(pair.node.left, 1));
                }
            } else if (pair.num == 2) {
                pair.num = pair.num + 1;
                st.push(new Pairs(pair.node, pair.num));
                inOrder.add(pair.node.val);
                if (pair.node.right != null) {
                    st.push(new Pairs(pair.node.right, 1));
                }
            } else {
                postOrder.add(pair.node.val);
            }
        }
        System.out.println("preOrder :" + preOrder);
        System.out.println("inOrder :" + inOrder);
        System.out.println("postOrder :" + postOrder);
    }
}

class Pairs{
    TreeNode node;
    int num;
    Pairs(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}
