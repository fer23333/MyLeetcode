    string包含大小写找到最长的palidrome length
   abccccdd ->dccaccd 最长为7
   将偶数和奇数频率的统计
   奇数做向下取整 3/2*2 = 2
   若包含奇数 最后还需加1
   
    public int longestPalindrome(String s) {
        if(s == null || s.length()  == 0){
            return 0;
        }
        int[] dic = new int[256];
        for(char c :s.toCharArray()){
            dic[c] ++;
        }
        int count = 0;
        int odd = 0;
        for(int i =0; i< dic.length; i++){
            if(dic[i] %2 != 0){
                odd = 1;
            }
            count += (dic[i]/2)*2;
        }
        return odd == 1 ? count+1 : count;
    }
