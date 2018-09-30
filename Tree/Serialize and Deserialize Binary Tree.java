class TreeNode {
     int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Codec{
    public static void main(String[] args){
         Codec codec = new Codec();
         codec.deserialize(codec.serialize(root));

    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        StringBuilder sb = new StringBuilder();
        helperS(root, sb);
        System.out.println(sb.toString());
        sb.deleteCharAt(sb.length() - 1);
        return(sb.toString());
    }
    public static void helperS(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null"+ ",");
            return;
        }
        sb.append(root.val+ ",");
        helper(root.left, sb);
        helper(root.right, sb);
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
        else
            TreeNode node =  new TreeNode(Integer.valueOf(val));
            node.left = helperD(nodes);
            node.right = helperD(nodes);
            return node;
    }
}
