
    public int[] getStream(String s) {
        // Write your code here
        int[] ans = new int[s.length()];
        int[] dic = new int[256];
        int cnt = 0;
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(dic[c -'a'] % 2 != 0){
                cnt--;
            }else{
                cnt++;    
            }
            dic[c-'a']++;
            if(cnt >1){
                ans[i] = 0;
            }else{
                ans[i] = 1;
            }
            
        }
        return ans;
   
    }
