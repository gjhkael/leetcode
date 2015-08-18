package algorithm.Tree;

/**
 * Created by hy on 2015/8/8.
 */
public class Isbalanced{


    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        if(Math.abs(heigh(root.left)-heigh(root.right))>1)
            return false;
        return isBalanced(root.left)&&isBalanced(root.right);

    }
    public int heigh(TreeNode node){
        if(node==null)
            return 0;
        return Math.max(heigh(node.left),heigh(node.right))+1;
    }
}
