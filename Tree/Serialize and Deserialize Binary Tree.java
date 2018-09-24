//preorder traversal recursive
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[null]";
        List<String> list = new ArrayList<>();
        helper(root, list);
        System.out.println(list.toString());
        return list.toString();
    }
    public static void helper(TreeNode root, List<String> list){
        if(root == null){
            list.add(null);
            return;            
        } 

        list.add(String.valueOf(root.val));
        helper(root.left, list);
        helper(root.right, list);
    }
