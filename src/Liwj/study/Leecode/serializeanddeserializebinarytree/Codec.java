package Liwj.study.Leecode.serializeanddeserializebinarytree;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2021/5/17.
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class Codec {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node.left = node2;
        node.right = node3;
        node3.left = node4;
        node3.right = node5;

        new Codec().deserialize(new Codec().serialize(node));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        } else {
            String serializestr = root.val + ",";
            serializestr += serialize(root.left);
            serializestr += serialize(root.right);
            return serializestr;
        }

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] node = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(node));
        return rializeList(list);
    }

    public TreeNode rializeList(List<String> data) {
        if (data.get(0).equals("null")){
            data.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        node.left = rializeList(data);
        node.right = rializeList(data);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));