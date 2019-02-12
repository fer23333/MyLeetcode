 
O(n2) O(1)
 
最长的substring 不可以跳过或者改变某一元素序列

那么对于找回文字串的问题，就要以每一个字符为中心，像两边扩散来寻找回文串，这个算法的时间复杂度是O(n*n)，
就是要注意奇偶情况，由于回文串的长度可奇可偶，比如"bob"是奇数形式的回文，"noon"就是偶数形式的回文，两种形式的回文都要搜索，
对于奇数形式的，我们就从遍历到的位置为中心，向两边进行扩散，对于偶数情况，我们就把当前位置和下一个位置当作偶数行回文的最中间两个字符，
然后向两边进行搜索
 
    private String res = "";
    public String longestPalindrome(String s) {
        if(s == null || s.length() <2 ){
            return s;
        }
        
        for(int i=0; i< s.length(); i++){
            extend(s, i, i );
            extend(s, i, i+1);
        }
        return res;
        
    }
    public void extend(String s,int left, int right){
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
     //由于会多做一步直到交叉 所以substring(left+1, right) 开区间
        String cur = s.substring(left+1, right);
        if(cur.length() > res.length()){
            res = cur;
        }
    }

O(n2) O(n2) space可以优化到O(n)
dp(i, j) represents whether s(i ... j) can form a palindromic substring, 
dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring. 
When we found a palindrome, check if it's the longest one. Time complexity O(n^2).
 
public String longestPalindrome(String s) {
  int n = s.length();
  String res = null;
    
  boolean[][] dp = new boolean[n][n];
    
  for (int i = n - 1; i >= 0; i--) {
    for (int j = i; j < n; j++) {
      dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
            
      if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
        res = s.substring(i, j + 1);
      }
    }
  }
    
  return res;
}
