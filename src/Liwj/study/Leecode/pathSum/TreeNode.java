package Liwj.study.Leecode.pathSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2021/5/11.
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static void main(String[] args) {
        new Solution().pathSum(new TreeNode(5,new TreeNode(4,new TreeNode(11,new TreeNode(7),new TreeNode(2)),null),new TreeNode(8,new TreeNode(13),new TreeNode(4,new TreeNode(5),new TreeNode(1)))),22);
    }

    LinkedList<Integer> list = new LinkedList<Integer>();
    List<List<Integer>> lists = new LinkedList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        getLists(root,target);
        return lists;
    }

    public void getLists(TreeNode root, int target){
        if (root == null || target < 0) {
            return ;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0  && root.left == null && root.right == null){
            lists.add(new LinkedList<>(list));
            list.removeLast();
            return;
        }
        getLists(root.left,target);
        getLists(root.right,target);
        list.removeLast();
    }
}
