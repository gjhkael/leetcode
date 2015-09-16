package algorithm.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hy on 2015/9/16.
 */
public class TreePaths {

    public static void main(String[] args){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(10);
        root.right = new TreeNode(13);
        List<String> result = treePaths(root);
        for(String s :result){
            System.out.println(s);
        }
    }

    public static List<String> treePaths(TreeNode root){
        List<String> result = new ArrayList<String>();
        if(root == null)
            return result;
        String str = "";
        paths(result,root,str);
        return result;
    }
    public static void paths(List<String> result, TreeNode node,String str){

        if(node.left==null && node.right ==null){
            str+=node.val;
            result.add(new String(str));
            return;
        }
        if(node.left!=null) paths(result,node.left,str+node.val+"->");
        if(node.right!=null) paths(result,node.right,str+node.val+"->");
    }
}
