package interviewQA.Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.offer(root);
        int count = 1;
        TreeNode node = root;
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < len; i++){
                node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
                list.add(node.val);
            }
            if(count % 2 == 0){
                reverse(list);
            }
            ans.add(list);
            count++;
        }
        return ans;
    }

    public void reverse(List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while(l <= r){
            int x = list.get(l);
            list.set(l, list.get(r));
            list.set(r, x);
            l++;
            r--;
        }
    }
}
