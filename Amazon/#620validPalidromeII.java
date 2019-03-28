    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int l =0, r = s.length()-1;
        while(l < r && s.charAt(l) == s.charAt(r)){
            l++;
            r--;
        }
        if(l>=r){
            return true;
        }
        if(isValid(s, l+1, r) || isValid(s, l, r-1)){
            return true;
        }
        return false;
    }
    public boolean isValid(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }    
        return true;
    }
