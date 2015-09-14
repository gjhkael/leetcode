package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hy on 2015/9/14.
 */
public class BinaryTreePaths {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        List<String> s =binaryTreePaths(root);
        for(String t:s){
            System.out.println(t);
        }

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        String str = "";
        binaryTreePaths(root,result,str);
        return result;
    }

    public  static void binaryTreePaths(TreeNode root,List<String> result,String str){
        if(root == null)
            return;

        if(root.left==null && root.right==null){
            str+=root.val;
            result.add(new String(str));
            return;
        }
        binaryTreePaths(root.left,result,str+root.val+"->");
        binaryTreePaths(root.right,result,str+root.val+"->");

    }
}
