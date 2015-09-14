package algorithm.Tree;

/**
 * Created by hy on 2015/9/14.
 */
public class IsBalancedTree {

    public boolean isBalanced(TreeNode root){
        return banlanced(root)>=0;
    }
    public int banlanced(TreeNode node){
        if(node ==null){
            return 0;
        }
        int ld = banlanced(node.left);
        int rd = banlanced(node.right);
        if(ld>=0 && rd>=0 && Math.abs(ld-rd)<2)
            return 1+Math.max(ld,rd);
        else
            return -1;
    }

    public boolean isBalanced1(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>=2){
            return false;
        }
        return isBalanced1(root.left)&&isBalanced1(root.right);

    }

    public int height(TreeNode root){
        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right)+1;
    }


}
