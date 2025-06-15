package interviewQA.Trees.BinaryTrees;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversalOfABinaryTree {

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<NodeInfo> q = new LinkedList<>();
        List<NodeInfo> nodeList = new ArrayList<>();
        TreeNode node = root;
        if(node == null)
            return new ArrayList<List<Integer>>();
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
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for(NodeInfo nl : nodeList){
            if(nl.col != prevCol){
                if(!currList.isEmpty()){
                    result.add(currList);
                }
                currList = new ArrayList();
                prevCol = nl.col;
            }
            currList.add(nl.node.val);
        }
        result.add(currList);
        return result;
    }
}

class NodeInfo{
    TreeNode node;
    int row;
    int col;

    NodeInfo(TreeNode node, int col, int row){
        this.row = row;
        this.node = node;
        this.col = col;
    }
}
