O(n) O(n)
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
    
 O(n) O(1)
 不使用额外空间的话， 使用双指针 并设立 isvalid函数 查看是否为letter or digit
 java 可以调用 Character.isLetterOrDigit(); 
 先while到valid character 然后判定是否去除大小写后相同
Character.toLowerCase();
 
 注意left< right 如果 left<= right " ", "." 首先这些情况 会使指针越界 
 而且 ".," left右移一位后由于left=right仍然会再走一步 此时就越界了 所以要维持l和r差一位 最后再合成一位
       lr
 
     public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;

        while(left<right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
               return false;
            }
            
            left++;
            right--;
        }
        return true;
    }
