package algorithm.SwordOffer;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by havstack on 9/6/15.
 */
public class LevelOrderPrintTree23 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        levelOrderPrintTree(root);
    }

    public static void levelOrderPrintTree(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tmp=queue.poll();
            System.out.print(tmp.val+" ");
            if(tmp.left!=null)
                queue.add(tmp.left);
            if(tmp.right!=null)
                queue.add(tmp.right);
        }
    }
}

