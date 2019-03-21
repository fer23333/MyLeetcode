package com.company;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//[1,2,3,null,null,4,5]
//1,2,null,null,3,4,null,null,5,null,null
//[1,2,3,null,null,4,5]

class Codec{

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
    //使用linkedlist(Queue) 用 stack也可以 倒着放进去 每次都pop
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
    //不使用linkedlist 使用index数组
        public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] datas = data.split(",");
        int[] index = new int[]{0};
        return helperD(datas, index);
        
    } 
    public static TreeNode helperD(String[] datas, int[] index){
        if(index[0] == datas.length){
            return null;
        }
        String visiting = datas[index[0]++];
        if(visiting.equals("null")){
            return null;
        }
        
        TreeNode node =  new TreeNode(Integer.valueOf(visiting));
        node.left = helperD(datas, index);
        node.right = helperD(datas, index);
        return node;
    }
}


//bfs 版本


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                TreeNode cur = q.poll();
                if(cur == null){
                    res.append("null,");  
                    continue;
                }
                res.append(cur.val + ",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        res.deleteCharAt(res.length() -1);
        System.out.println(res.toString());
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }        
        Queue<TreeNode> q = new LinkedList<>();
        String[] node = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(node[0]));
        q.offer(root);
        for(int i=1; i< node.length-1; i++){
            TreeNode cur = q.poll();
            System.out.println(cur.val);
            if(!node[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(node[i]));
                cur.left = left;
                q.offer(left);
            }
            if(!node[++i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(node[i]));
                cur.right = right;
                q.offer(right);
            }
        }
        return root;
    }
