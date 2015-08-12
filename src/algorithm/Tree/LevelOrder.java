package algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hy on 2015/8/7.
 */
public class LevelOrder {
    public static void main(String[] args){

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);

        System.out.println(new LevelOrder().levelOrder(root));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return null;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        Queue<TreeNode> queue1=new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> level=new ArrayList<Integer>();
        List<List<Integer>> result=new ArrayList<List<Integer>>();

        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.left!=null){
                queue1.add(cur.left);
            }
            if(cur.right!=null){
                queue1.add(cur.right);
            }
            level.add(cur.val);
            if(queue.isEmpty()){
                queue=queue1;
                queue1=new LinkedList<TreeNode>();
                result.add(level);
                level=new ArrayList<Integer>();
            }

        }

        return result;
    }
}
