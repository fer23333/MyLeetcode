class Node{
	List<Node> children;
	int val;
	Node(){}
	Node(List<Node> children, int val){
		this.children = children;
		this.val = val;
	}
}

public maxDepth(Node root){
		if(root == null){
			return 0;
		}
		int max =0;
		for(Node child : root.children){
			max = Math.max(max, maxDepth(child));
		}
		return max + 1;
}
