package interviewQA.Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                res.append("n ");
                continue;
            }
            res.append(node.val).append(" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return res.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if(data == null || data == ""){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] input = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        queue.offer(root);
        for(int i = 1; i < input.length; i++){
            TreeNode parent = queue.poll();
            if(!input[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(input[i]));
                parent.left = left;
                queue.offer(left);
            }
            if(!input[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(input[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}
