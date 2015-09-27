package algorithm.SwordOffer;

/**
 * Created by kael on 9/5/15.
 */
//将二叉树转换成其镜像树
public class MirrorRecursively19 {

    public static void main(String[] args){
        TreeNode root=new TreeNode(12);
        root.left=new TreeNode(1);
        mirrorRecursively(root);
        System.out.println(root.right.val);

    }

    public static void mirrorRecursively(TreeNode root){
        if(root==null||(root.left==null&&root.right==null))
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right=tmp;
        mirrorRecursively(root.left);
        mirrorRecursively(root.right);
    }
}
