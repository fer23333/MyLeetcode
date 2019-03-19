 // 寻找3-abc这样的全部permutation, '1' 从 character转化为数字 使用 Character.getNumericValue
 public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        } 
        String[] map = {"", "", "abc","def","ghi", "jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        dfs(digits, sb, result, map, 0);
        return result;
    }
    public void dfs(String digits, StringBuilder sb, 
                    List<String> result, String[] map,
                   int index){
        
        if(digits.length() == index){
            result.add(sb.toString());
            return;
        }
        for(char c : map[Character.getNumericValue(digits.charAt(index))].toCharArray()){
            sb.append(c);
            dfs(digits, sb, result, map, index+1);
            sb.deleteCharAt(sb.length() -1);
        }
    }
        //利用 string immutable的特点
        
        public List<String> letterCombinations(String digits) {
        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        dfs(0, digits.length(), "", digits, phone, ans);
        return ans;
    }
    
    private void dfs(int x, int l, String str, String digits, String phone[], List<String> ans) {
        if (x == l) {
            ans.add(str);
            return;
        }
        int d = digits.charAt(x) - '0';
        for (char c : phone[d].toCharArray()) {
            dfs(x + 1, l, str + c, digits, phone, ans);
        }
    }
