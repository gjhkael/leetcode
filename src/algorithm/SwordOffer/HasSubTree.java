package algorithm.SwordOffer;

import sun.reflect.generics.tree.Tree;

/**
 * Created by kael on 9/5/15.
 */
public class HasSubTree {

    public static void main(String[] args){

        TreeNode root1 =new TreeNode(12);
        TreeNode root2 =new TreeNode(12);
        root2.left = new TreeNode(1);

        System.out.println(hasSubTree(root1,root2));
    }


    public static boolean hasSubTree(TreeNode root1,TreeNode root2){
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val==root2.val)
                result = doesHasSubTree(root1,root2);
            if(!result){
                result = hasSubTree(root1.left,root2);
            }
            if(!result)
                result = hasSubTree(root1.right,root2);
        }
        return result;

    }

    public static boolean doesHasSubTree(TreeNode node1,TreeNode node2){
        if(node2==null){
            return true;
        }
        if(node1==null){
            return false;
        }
        if(node1.val!=node2.val){
            return false;
        }
        return doesHasSubTree(node1.left,node2.left)&&doesHasSubTree(node1.right,node2.right);
    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
}