package algorithm.SwordOffer;

/**
 * Created by hy on 2015/8/18.
 */
public class ConvertBSTDll {
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

        TreeNode root=convertBST(r1);
        while(root!=null){
            System.out.println(root.val);
            root=root.right;
        }
    }
    public static TreeNode convertBST(TreeNode root){
        root=convertBSTDll(root);

        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static TreeNode convertBSTDll(TreeNode root){
        if(root==null || (root.left==null&&root.right==null))
            return root;
        if(root.left!=null){
            TreeNode tmp=convertBSTDll(root.left);
            while(tmp.right!=null){
                tmp=tmp.right;
            }
            tmp.right=root;
            root.left=tmp;
        }
        if(root.right!=null){
            TreeNode tmp=convertBSTDll(root.right);
            while(tmp.left!=null){
                tmp=tmp.left;
            }
            tmp.left=root;
            root.right=tmp;
        }
        return root;
    }

}
