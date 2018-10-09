//O(n2)暴力解 遍历所有节点 以每个节点为root的都看一下
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int helper(TreeNode node, int sum){
        if(node == null) return 0;
        return (node.val == sum ? 1:0 ) + helper(node.left, sum - node.val)
        + helper(node.right, sum - node.val);
    }

//prefix_sum map + dfs
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        return helper(root, sum, map, prefixSum);
    }
    public int helper(TreeNode root, int sum, Map<Integer, Integer> map, int prefixSum){
        if(root == null) return 0;
        prefixSum += root.val;
        int res = map.getOrDefault(prefixSum - sum, 0);
        map.put(prefixSum, map.getOrDefault(prefixSum, 0)+ 1);
        res += helper(root.left, sum, map, prefixSum) + helper(root.right, sum, map, prefixSum);
        map.put(prefixSum, map.get(prefixSum) -1);
        return res;
    }
