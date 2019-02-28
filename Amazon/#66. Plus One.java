// 对一个长度为n的数组 末尾加1 
//[4,5,6]-> [4,5,7]
//设计循环 如果没有进位 直接返回 array 或者在某次没有进位时 也返回array
//如果会跳出该循环 说明 要加一位最高位1

    public int[] plusOne(int[] digits) {
        for(int i = digits.length -1; i>=0; i--){
            if(digits[i]< 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNum = new int[digits.length +1];
        for(int i=1; i< digits.length; i++){
            newNum[i] = digits[i];
        }
        newNum[0] = 1;
        return newNum;
    }
