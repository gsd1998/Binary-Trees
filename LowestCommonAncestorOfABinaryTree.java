package interviewQA.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {
    boolean flag = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        pathFind(root, list1, p);
        flag = false;
        pathFind(root, list2, q);
        return findCommonAncestor(list1, list2);
    }

    public void pathFind(TreeNode node, List<TreeNode> list, TreeNode givenNode){
        if(node == null){
            return;
        }
        list.add(node);
        if(node == givenNode){
            flag = true;
            return;
        }
        pathFind(node.left, list, givenNode);
        if(flag) return;
        pathFind(node.right, list, givenNode);
        if(flag) return;
        list.remove(list.size()-1);
    }

    public TreeNode findCommonAncestor(List<TreeNode> list1, List<TreeNode> list2){
        int i = 0;
        int j = 0;
        TreeNode result = null;
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) == list2.get(j)){
                result = list1.get(i);
            }else{
                break;
            }
            i++;
            j++;
        }
        return result;
    }
}
