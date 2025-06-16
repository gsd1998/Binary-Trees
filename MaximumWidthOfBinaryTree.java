package interviewQA.Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int ans = 0;
        while(!q.isEmpty()){
            int len = q.size();
            int min = q.peek().index;
            int firstPos = 0;
            int lastPos = 0;
            for(int i = 0; i < len; i++){
                int reducedIndex = q.peek().index - min;
                if(i == 0){
                    firstPos = q.peek().index;
                }
                if(i == len-1){
                    lastPos = q.peek().index;
                }
                Pair pair = q.poll();
                TreeNode node = pair.node;
                if(node.left != null){
                    q.offer(new Pair(node.left, 2*reducedIndex+1));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right, 2*reducedIndex+2));
                }
            }
            ans = Math.max(ans, lastPos - firstPos + 1);
        }
        return ans;
    }
}

class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}
