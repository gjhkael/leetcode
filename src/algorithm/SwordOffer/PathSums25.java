package algorithm.SwordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by havstack on 9/6/15.
 */
public class PathSums25 {

    public static void main(String[] args){

        TreeNode root=new TreeNode(12);
        root.left=new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left=new TreeNode(5);
        List<List<Integer>> result=pathSum(root,22);
        System.out.println(result);

    }

    public static List<List<Integer>> pathSum(TreeNode root,int sum){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
        List<Integer> path=new ArrayList<Integer>();
        pathSum(root,sum,result,path);
        return result;
    }

    public static void pathSum(TreeNode root,int sum,List<List<Integer>>result,List<Integer>path){
        if(root==null){
            return;
        }
        path.add(root.val);
        if(root.left==null&&root.right==null&&sum==root.val){
            result.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }else{
            pathSum(root.left,sum-root.val,result,path);
            pathSum(root.right,sum-root.val,result,path);
        }
        path.remove(path.size()-1);
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.val==sum&&root.left==null&&root.right==null)
            return true;
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
