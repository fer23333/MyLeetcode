    注意for循环的写法
    kmp可以优化到o(n)
        
   String indexOf(String str) : This method returns the index 
   within this string of the first occurrence of the specified substring. If it does not occur as a substring, -1 is returned.
    
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
