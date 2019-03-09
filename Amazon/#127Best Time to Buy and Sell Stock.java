    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int curMax =0;
        int max = 0;
        for(int i=1; i< prices.length; i++){
            curMax = Math.max(prices[i]-prices[i-1]+curMax, prices[i]-prices[i-1]);
            max = Math.max(curMax, max);
        }

        return max;
    }
