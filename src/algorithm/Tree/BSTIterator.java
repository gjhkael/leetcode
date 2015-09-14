package algorithm.Tree;

import java.util.Stack;

/**
 * Created by hy on 2015/9/14.
 */
public class BSTIterator {


    private Stack<TreeNode> tmp;
    public BSTIterator(TreeNode root) {
        tmp=new Stack<TreeNode>();
        putLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !tmp.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {

        TreeNode pre=tmp.pop();
        if(pre.right!=null)
            putLeft(pre.right);
        return pre.val;
    }

    public void putLeft(TreeNode node){
        TreeNode cur=node;
        while(cur!=null){
            tmp.add(cur);
            cur=cur.left;
        }

    }
}
