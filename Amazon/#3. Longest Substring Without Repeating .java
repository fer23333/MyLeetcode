//O(n2)

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int maxLen = 0;
        
        for(int i=0; i< s.length(); i++){
            Set<Character> set = new HashSet<>();
            for(int j=i; j<s.length(); j++){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    maxLen = Math.max(maxLen, set.size());
                }else{
                    break;
                }
            }
        }
        return maxLen;
    }
    
    //O(2n), O(min(m,n)) 使用sliding window 优化
    //ij 两个指针 j一直前进 如果遇到相同 就把i所在的从set中除去 并往前进
        public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        int i=0, j=0;
        while(i< s.length() && j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, set.size());
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLen;
    }
    
    
    //使用 hashmap存 character 和所在的index  把i 更新到 重复点中最新位置的点
    
        public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0;
        while(i< s.length() && j<s.length()){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j)) + 1);
            }
                map.put(s.charAt(j), j);
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            
        }
        return maxLen;
    }
    //如果只有字符 可以使用 array代替hashmap 节省空间
   public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
