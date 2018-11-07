//start from any index find longest length subarray that contains at most two different numbers
//sliding window
class Solution {
    public int totalFruit(int[] tree) {
        //start from any index find longest length subarray that contains at most two different numbers
        //sliding window
        Map<Integer, Integer> map = new HashMap<>();
        int i=0, res = 0;
        for(int j=0; j< tree.length; j++){
            map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);
            while(map.size() > 2){
                map.put(tree[i], map.get(tree[i])- 1);
                if(map.get(tree[i]) == 0) 
                    map.remove(tree[i]);
                i++;
            }
            res = Math.max(res, j-i+1 );
        }
        return res;
        
    }
}
