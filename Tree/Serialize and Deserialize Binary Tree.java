package com.company;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Codec{
//    public static void main(String[] args) {
//        // write your code here
//        TreeNode root = new TreeNode(1);
//        TreeNode t1 = new TreeNode(2);
//        TreeNode t2 = new TreeNode(3);
//        root.left = t1;root.right = t2;
//        TreeNode t3 = new TreeNode(4);
//        TreeNode t4  = new TreeNode(5);
//        t2.left = t3; t2.right = t4;
//
//        Codec codec = new Codec();
//        codec.deserialize(codec.serialize(root));
//    }
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        StringBuilder sb = new StringBuilder();
        helperS(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return(sb.toString());
    }
    public static void helperS(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null"+ ",");
            return;
        }
        sb.append(root.val+ ",");
        helperS(root.left, sb);
        helperS(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] datas = data.split(",");
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(datas));
        return helperD(nodes);

    }
    public static TreeNode helperD(Deque<String> nodes){
        String val =  nodes.poll();
        if(val.equals("null")) return null;
        else{
            TreeNode node =  new TreeNode(Integer.valueOf(val));
            node.left = helperD(nodes);
            node.right = helperD(nodes);
            return node;
        }

    }
}
