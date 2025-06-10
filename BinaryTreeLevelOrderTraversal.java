package interviewQA.Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        TreeNode node = root;
        if(root == null){
            return ans;
        }
        q.offer(node);
        while(!q.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int len = q.size();
            for(int i = 0; i < len; i++){
                node = q.peek();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
                list.add(q.poll().val);
            }
            ans.add(list);
        }
        return ans;
    }
}
