package structure.Tree;

import java.util.List;

/**
 * Created by hy on 2015/9/25.
 */
//根据二叉树的前序和中序遍历来构造一颗二叉树
public class RebuildTree {
    public static void main(String[] args){
        int []num1 = {1,2,4,7,3,5,6,8};
        int []num2 = {4,7,2,1,5,3,8,6};
        TreeNode root = rebuildTree(num1,num2);
        System.out.println(root.left.val+" "+root.right.val);

    }

    public static TreeNode rebuildTree(int[] num1,int[]num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        TreeNode root = null;
        if (num1.length != 0 && num2.length != 0) {
            root = new TreeNode(num1[0]);
            int index = 0;
            for (int i = 0; i < num2.length; i++) {
                if (num2[i] == num1[0])
                    index = i;
            }
            int[] inOrderPre = new int[index];
            for (int i = 0; i < index; i++) {
                inOrderPre[i] = num2[i];
            }
            int[] inOrderAfter = new int[num2.length - index-1];
            int tmp = 0;
            for (int i = index + 1; i < num2.length; i++) {
                inOrderAfter[tmp++] = num2[i];
            }
            int[] preOrderPre = new int[index];
            tmp = 0;
            for (int i = 1; i < index + 1; i++) {
                preOrderPre[tmp++] = num1[i];
            }
            int[] preOrderAfter = new int[num1.length - index-1];
            tmp = 0;
            for (int i = index + 1; i < num1.length; i++) {
                preOrderAfter[tmp++] = num1[i];
            }
            root.left = rebuildTree(preOrderPre, inOrderPre);
            root.right = rebuildTree(preOrderAfter, inOrderAfter);
        }
        return root;
    }


    public static TreeNode rebuildTree1(List<Integer> list1,List<Integer> list2) {
        if(list1 ==null || list2==null)
            return null;
        TreeNode root = null;
        if(list1.size()>0 && list2.size()>0) {
            root = new TreeNode(list1.get(0));
            int index = list2.indexOf(list1.get(0));
            List<Integer> inOrderPre = list2.subList(0,index);
            List<Integer> inOrderAfter = list2.subList(index+1,inOrderPre.size());
            List<Integer> preOrderPre = list1.subList(1,index+1);
            List<Integer> preOrderAfter = list1.subList(index+1,list1.size());
            root.left = rebuildTree1(preOrderPre,inOrderPre);
            root.right = rebuildTree1(preOrderAfter,inOrderAfter);
        }
        return root;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
