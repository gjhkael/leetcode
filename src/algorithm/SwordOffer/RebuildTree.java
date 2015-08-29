package algorithm.SwordOffer;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hy on 2015/8/18.
 */
public class RebuildTree {
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public static void main(String[] args){
        List<Integer> pre=new ArrayList<Integer>(Arrays.asList(8,6,5,7,9));
        List<Integer> order=new ArrayList<Integer>(Arrays.asList(5,6,7,8,9));
        TreeNode root=rebuildTree(pre,order);
        System.out.println(root.val+" "+root.left.val);

    }

    public static TreeNode rebuildBinaryTreeRec(List<Integer> preOrder, List<Integer> inOrder){
        TreeNode root=null;
        List<Integer> leftPreOrder;
        List<Integer> rightPreOrder;
        List<Integer> leftInOrder;
        List<Integer> rightInOrder;
        if(preOrder.size()!=0&&inOrder.size()!=0){
            root=new TreeNode(preOrder.get(0));
            int indexInOrder=inOrder.indexOf(preOrder.get(0));
            leftInOrder=inOrder.subList(0,indexInOrder);
            rightInOrder=inOrder.subList(indexInOrder+1,inOrder.size());

            leftPreOrder = preOrder.subList(1, leftInOrder.size()+1);
            rightPreOrder = preOrder.subList(leftInOrder.size()+1,preOrder.size());
            root.left=rebuildBinaryTreeRec(leftPreOrder,leftInOrder);
            root.right=rebuildBinaryTreeRec(rightPreOrder,rightInOrder);
        }
        return root;
    }


    public static TreeNode rebuildTree(List<Integer>pre,List<Integer>inOrder){
        if(pre==null || inOrder==null){
            return null;
        }

        TreeNode root=null;
        List<Integer> leftPreOrder;
        List<Integer> rightPreOrder;
        List<Integer> leftInOrder;
        List<Integer> rightInOrder;
        if(pre.size()!=0 && inOrder.size()!=0){
            root=new TreeNode(pre.get(0));
            int indexOfRoot=inOrder.indexOf(pre.get(0));
            leftInOrder=inOrder.subList(0,indexOfRoot);
            rightInOrder=inOrder.subList(indexOfRoot+1,inOrder.size());

            leftPreOrder=pre.subList(1,leftInOrder.size()+1);
            rightPreOrder=pre.subList(leftInOrder.size()+1,pre.size());

            root.left=rebuildTree(leftPreOrder,leftInOrder);
            root.right=rebuildTree(rightPreOrder,rightInOrder);
        }
        return root;
    }
}
