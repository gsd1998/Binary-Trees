package interviewQA.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preOrderP(p, list1);
        preOrderQ(q, list2);
        return list1.equals(list2);
    }

    public void preOrderP(TreeNode p, List<Integer> list1){
        if(p == null){
            list1.add(null);
            return;
        }
        list1.add(p.val);
        preOrderP(p.left, list1);
        preOrderP(p.right, list1);
    }

    public void preOrderQ(TreeNode q, List<Integer> list2){
        if(q == null){
            list2.add(null);
            return;
        }
        list2.add(q.val);
        preOrderQ(q.left, list2);
        preOrderQ(q.right, list2);
    }

    public boolean isSameTreeOptimal(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
