package interviewQA.Trees.BinaryTrees;

import java.util.*;

public class AllNodesDistanceKInBinaryTree{
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentTracker = new HashMap<>();
        markTheParentNodes(parentTracker, root);
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int distance  = 0;
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            if(distance == k){
                break;
            }
            distance++;
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
                if(parentTracker.get(current) != null && visited.get(parentTracker.get(current)) == null){
                    queue.offer(parentTracker.get(current));
                    visited.put(parentTracker.get(current), true);
                }
            }
        }
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }

    public void markTheParentNodes(HashMap<TreeNode,TreeNode> parentTracker, TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.offer(node.left);
                parentTracker.put(node.left, node);
            }
            if(node.right != null){
                q.offer(node.right);
                parentTracker.put(node.right, node);
            }
        }
    }
}
