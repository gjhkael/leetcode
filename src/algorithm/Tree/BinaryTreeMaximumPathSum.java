package algorithm.Tree;

import algorithm.leetcode.Utils;

/**
 * 求一个二叉数的路径，使其和最大
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args){
        TreeNode root=new TreeNode(12);
        root.left=new TreeNode(13);
        root.right=new TreeNode(1);
        System.out.println(new BinaryTreeMaximumPathSum().binaryTreeMaximum(root));
    }
    public int binaryTreeMaximum(TreeNode node){
        binaryTreeMaximumPathSum(node);
        return maxValue;
    }
    public  int binaryTreeMaximumPathSum(TreeNode node){
        if(node==null)
            return 0;
        int left=Utils.max(0, binaryTreeMaximumPathSum(node.left)); //返回左子树最大路径长，为负数的话返回0
        int right=Utils.max(0, binaryTreeMaximumPathSum(node.right)); //返回右子树最大路径长，为负数的话返回0
        maxValue=Utils.max(maxValue,left+right+node.val);         //这里很关键，利用一个对象实例变量保存最大值
        return Utils.max(left,right)+node.val;                   //返回左子树和右子树最大值与当前节点和
    }
    private int maxValue=Integer.MIN_VALUE;
}

