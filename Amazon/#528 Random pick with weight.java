class Solution {
    private int[] wSum;
    private Random rand;
    public Solution(int[] w) {
        int sum = 0;
        wSum = new int[w.length];
        for(int i =0; i< w.length; i++){
            sum += w[i];
            wSum[i] = sum;
        }
        rand = new Random();
    }
    
    public int pickIndex() {
        int size = wSum[wSum.length -1];
        int index = rand.nextInt(size) +1;
        int left =0;
        int right = wSum.length-1;
        while(left < right){
            int mid = left + (right - left) /2;
            if(wSum[mid] == index){
                return mid;
            }else if(wSum[mid] < index){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
