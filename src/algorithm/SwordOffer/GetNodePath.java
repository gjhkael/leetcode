package algorithm.SwordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hy on 2015/8/18.
 */
public class GetNodePath {


    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public static void main(String[] args){
        TreeNode r1 = new TreeNode(6);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(8);
        TreeNode r4 = new TreeNode(3);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(7);
        TreeNode r7 = new TreeNode(9);
        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r7;
        r3.left=r6;
        List<TreeNode> path=new ArrayList<TreeNode>();
        getNodePath(r1,r3,path);
        for(TreeNode s:path){
            System.out.println(s.val);
        }

    }
    public  static boolean getNodePath(TreeNode root,TreeNode node,List<TreeNode> path){
        if(root ==null)
            return false;
        path.add(root);
        if(root==node)
            return true;
        boolean foundIt=false;
        foundIt=getNodePath(root.left,node,path);
        if(!foundIt)
            foundIt=getNodePath(root.right,node,path);
        if(!foundIt)
            path.remove(root);
        return false;
    }
}
