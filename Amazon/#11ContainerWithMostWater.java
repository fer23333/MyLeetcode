//考虑短板效应 刚开始是长度最长情况 为了找到最大面积 
//缩小长度 从height寻找 哪个height小 哪个指针++
// 面积为 (right-left) * min(height(left), height(right))

public int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }    
        int max =0;
        int left = 0;
        int right = height.length- 1;
        while(left < right){
            int area = (right - left)*(Math.min(height[left], height[right]));
            max = Math.max(max, area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
