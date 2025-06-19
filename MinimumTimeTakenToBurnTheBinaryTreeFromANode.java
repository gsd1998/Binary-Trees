package interviewQA.Trees.BinaryTrees;

import java.util.*;
public class MinimumTimeTakenToBurnTheBinaryTreeFromANode {

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.right = new TreeNode(7);*/

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode targetNode = root.right.right;
        int ans = timeTaken(root, targetNode);
        System.out.println(ans);//5
    }

    public static int timeTaken(TreeNode root, TreeNode targetNode) {
        HashMap<TreeNode, TreeNode> parentNodes = new HashMap<>();
        markTheParentNode(root, parentNodes);
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        queue.offer(targetNode);
        visited.put(targetNode, true);
        int seconds = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            seconds++;
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(current.left != null && visited.get(current.left) == null){
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parentNodes.get(current) != null && visited.get(parentNodes.get(current)) == null){
                    queue.offer(parentNodes.get(current));
                    visited.put(parentNodes.get(current), true);
                }
            }
        }
        return seconds-1;
    }

    public static void markTheParentNode(TreeNode root, HashMap<TreeNode,TreeNode> parentNodes){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.offer(node.left);
                parentNodes.put(node.left, node);
            }
            if(node.right != null){
                q.offer(node.right);
                parentNodes.put(node.right, node);
            }
        }
    }

}
