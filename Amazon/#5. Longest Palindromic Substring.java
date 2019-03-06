private int maxLen,low;
    public String longestPalindrome(String s) {
        if(s == null || s.length()  == 0){
            return "";
        }
        
        
        for(int i =0; i< s.length(); i++){
            //even
            extend(s,i,i+1);
            //odd
            extend(s,i,i);
        }
        return s.substring(low, low+maxLen);
    }
    public void extend(String s, int l, int r){
        while(l>=0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)){
            if(r-l+1 > maxLen){
                maxLen = r-l+1;
                low = l;
            }
            l--;
            r++;
        }
        
    }
