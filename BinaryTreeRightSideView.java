package interviewQA.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<NodeInfo> q = new LinkedList<>();
        List<NodeInfo> nodeList = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        TreeNode node = root;
        q.offer(new NodeInfo(root,0,0));
        while(!q.isEmpty()){
            NodeInfo currentNode = q.poll();
            nodeList.add(currentNode);
            if(currentNode.node.right != null){
                q.offer(new NodeInfo(currentNode.node.right, currentNode.col+1, currentNode.row+1));
            }
            if(currentNode.node.left != null){
                q.offer(new NodeInfo(currentNode.node.left, currentNode.col-1, currentNode.row+1));
            }
        }

        int prevRow = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        for(NodeInfo ni : nodeList){
            if(ni.row != prevRow){
                result.add(ni.node.val);
                prevRow = ni.row;
            }
        }
        return result;
    }

    //Solving without using NodeInfo
    public List<Integer> rightSideViewDiffApproach(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> nodeList = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        TreeNode node = root;
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                TreeNode currentNode = q.poll();
                if(i == 0){
                    nodeList.add(currentNode.val);
                }
                if(currentNode.right != null){
                    q.offer(currentNode.right);
                }
                if(currentNode.left != null){
                    q.offer(currentNode.left);
                }
            }
        }
        return nodeList;
    }

    /* Using Recursion */
    public List<Integer> rightSideViewOptimised(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recurse(root, 0, list);
        return list;
    }

    public void recurse(TreeNode root, int level, List<Integer> list) {
        if(root == null){
            return;
        }
        if(level == list.size()){
            list.add(root.val);
        }
        recurse(root.right, level+1, list);
        recurse(root.left, level+1, list);
    }

}
