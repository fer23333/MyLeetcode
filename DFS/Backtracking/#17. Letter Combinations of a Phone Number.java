// 用length控制 digits的层数, 用for循环控制 dic的位置
//
//("23")->["ad","ae","af","bd","be","bf","cd","ce","cf"]
//stringbuilder的做法比较好, 而且不会创建很多object 
public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        String[] dic= {" ", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(res, digits, dic, new StringBuilder(), 0);
        return res;
    }
    public void dfs(List<String> res, String digits, String[] dic, StringBuilder sb, int length){
        if(length == digits.length()){
            res.add(sb.toString());
            return;
        }
        int index = digits.charAt(length) - '0';
        for(char c : dic[index].toCharArray()){
            sb.append(String.valueOf(c));
            dfs(res, digits, dic, sb, length+1);
            sb.deleteCharAt(sb.length() -1);
        }
        
    }
//使用 string 只传递 prefix
public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        String[] dic= {" ", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(res, digits, dic, "", 0);
        return res;
    }
    public void dfs(List<String> res, String digits, String[] dic, String prefix, int length){
        if(length == digits.length()){
            res.add(prefix);
            return;
        }
        String letter = dic[digits.charAt(length) - '0'];
        for(int i=0; i< letter.length(); i++){
            dfs(res, digits, dic, prefix + letter.charAt(i), length+1);
        }
    }

//iterative
List<String> ans = new LinkedList<String>();
if (digits.isEmpty())
        return ans;
String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
ans.add(0, "");
for (int i = 0; i < digits.length(); i++) {
        int x = Character.getNumericValue(digits.charAt(i));
        int size = ans.size();     // number of nodes/strings already in the queue
        for (int k = 1; k <= size; k++) {
                String t = ans.remove(0);
                for (char s : mapping[x].toCharArray())
                        ans.add(t + s);
        }
}
return ans;
