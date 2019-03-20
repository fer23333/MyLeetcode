package com.dailytest;
import java.util.*;
class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
        this.left = this.right = null;
    }
}
public class StringAndSB {
    public static String sbMethod(TreeNode root){
        if(root == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        sb.deleteCharAt(sb.length() -1);
        return sb.toString();

    }
    public static void dfs(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    public static String stringMethod(TreeNode root){
        if(root == null){
            return null;
        }
        String res = "";
        helper(root, res);
        return res;
    }
    public static void helper(TreeNode root, String res){
        if(root == null){
            res = res + "null,";
            return;
        }
        res = res + String.valueOf(root.val)+ ",";
        helper(root.left, res);
        helper(root.right, res);
    }
    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode sLeft = new TreeNode(4);
        TreeNode sRight = new TreeNode(5);

        root.left =left;
        root.right =right;
        left.left= sLeft;
        left.right = sRight;
        String s = sbMethod(root);
        String str = stringMethod(root);
        String se = serialize(root);
    }
    public static String serialize(TreeNode root) {
        return serializeHelper(root,"");
    }

    private static String serializeHelper(TreeNode root, String str){
        if (root == null){
            str +="null,";
            return str;
        }
        // preorder add node
        str += root.val + ",";
        str = serializeHelper(root.left, str);
        str = serializeHelper(root.right, str);

        return str;


    }

}



