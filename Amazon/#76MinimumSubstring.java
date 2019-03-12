//ADOBECODEBANC
//ABC
//O(n)解决 FLAG必考题 sliding window

    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        int[] cnt = new int[256];
        for(char ch : t.toCharArray()){
            cnt[ch]++;
        }
        int left = 0, right = 0, min = Integer.MAX_VALUE, total = t.length();
        int start = 0;
        while(right < s.length()){
            if(cnt[s.charAt(right)]-- > 0){
                total--;
            }
            while(total == 0){
                if(min > right -left +1){
                    min = right-left+1;
                    start = left;
                }
                if(++cnt[s.charAt(left++)] > 0){
                    total++;
                }
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? "": s.substring(start,start+min);
    }

