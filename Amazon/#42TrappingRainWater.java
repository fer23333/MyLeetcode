//用两个数组 分别记录 leftmax 和rightmax 
//比较 leftmost和rightmost 较低的值 如果比当前值大 就可以存水
//              *
// *            *    
// *     *      *
//timeO(n) spaceO(n)
//    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int[] leftMost = new int[height.length];
        int[] rightMost = new int[height.length];
        int leftMax = 0;
        int rightMax = 0;
        for(int i =0; i< height.length; i++){
            leftMax = Math.max(height[i], leftMax);
            leftMost[i] = leftMax;
        }
        for(int i = height.length -1; i>=0; i--){
            rightMax = Math.max(height[i], rightMax);
            rightMost[i] = rightMax;
        }
        int sum = 0;
        for(int i =0; i< height.length; i++){
            int min = Math.min(leftMost[i], rightMost[i]);
            if(height[i] < min){   
                sum += min - height[i];
            }
        }
        return sum;
    }
    
//双指针 timeO(n), space O(1)
//原理和 container with most water 的木桶原理相似
//设立leftmax rightmax两坐墙 然后移动短的一边 对leftmax 和left 或者 rightmax 和right 做差值 
    public int trap(int[] height) {
        int a=0;
        int b=height.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
            //a<= b 也可以
        while(a< b){
            leftmax=Math.max(leftmax,height[a]);
            rightmax=Math.max(rightmax,height[b]);
            if(leftmax<rightmax){
                    //leftmax== rightmax 在那边都一样
                max+=(leftmax-height[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            }
            else{
                max+=(rightmax-height[b]);
                b--;
            }
        }
        return max;
    }
