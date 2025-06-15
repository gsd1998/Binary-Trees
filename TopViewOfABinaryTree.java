package interviewQA.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopViewOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        List<Integer> result = topView(root);//[4, 2, 1, 3, 10]
        System.out.println(result);
    }

    public static List<Integer> topView(TreeNode root) {
        Queue<NodeInfo> q = new LinkedList<>();
        List<NodeInfo> nodeList = new ArrayList<>();
        TreeNode node = root;
        if(node == null)
            return new ArrayList<>();
        q.offer(new NodeInfo(node, 0, 0));
        while(!q.isEmpty()){
            NodeInfo currentNode = q.poll();
            nodeList.add(currentNode);
            if(currentNode.node.left != null){
                q.offer(new NodeInfo(currentNode.node.left, currentNode.col-1, currentNode.row+1));
            }
            if(currentNode.node.right != null){
                q.offer(new NodeInfo(currentNode.node.right, currentNode.col+1, currentNode.row+1));
            }
        }
        nodeList.sort((nl1, nl2) -> {
            if(nl1.col != nl2.col){
                return Integer.compare(nl1.col, nl2.col);
            }
            else if(nl1.row != nl2.row){
                return Integer.compare(nl1.row, nl2.row);
            }
            else{
                return Integer.compare(nl1.node.val, nl2.node.val);
            }
        });

        List<Integer> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for(NodeInfo nl : nodeList){
            if(nl.col != prevCol){
                result.add(nl.node.val);
                prevCol = nl.col;
            }
        }
        return result;
    }
}
