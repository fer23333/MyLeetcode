    注意for循环的写法
    kmp可以优化到o(n)
        
   String indexOf(String str) : This method returns the index 
   within this string of the first occurrence of the specified substring. If it does not occur as a substring, -1 is returned.
    
//     这道题让我们在一个字符串中找另一个字符串第一次出现的位置，那我们首先要做一些判断，
//     如果子字符串为空，则返回0，如果子字符串长度大于母字符串长度，则返回-1。
//     然后我们开始遍历母字符串，我们并不需要遍历整个母字符串，而是遍历到剩下的长度和子字符串相等的位置即可，
//     这样可以提高运算效率。然后对于每一个字符，我们都遍历一遍子字符串，一个一个字符的对应比较，
//     如果对应位置有不等的，则跳出循环，如果一直都没有跳出循环，则说明子字符串出现了，则返回起始位置即可
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }

        int m = haystack.length(); int n = needle.length();
        for(int i =0; i<= m-n; i++){
            int j =0;
            for(j=0; j< n;j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
            }
            if(j == n){
                return i;
            }
        }
        return -1;
    }

// more elegant
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() ==0 || needle.trim().equals("")){
            return 0; 
        }      
        for(int i =0; ;i++){
            for(int j =0; ; j++){
                if(j == needle.length()){
                    return i;
                }
                if(i+j == haystack.length()){
                    return -1;
                }
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;  
                }
            }      
        }
    }
