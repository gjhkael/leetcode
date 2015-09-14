package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

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

}
