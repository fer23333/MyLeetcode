// 用length控制 digits的层数, 用for循环控制 dic的位置
//
//("23")->["ad","ae","af","bd","be","bf","cd","ce","cf"]
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
        }else{
            for(char c : dic[digits.charAt(length) - '0'].toCharArray()){
                sb.append(String.valueOf(c));
                dfs(res, digits, dic, sb, length+1);
                sb.deleteCharAt(sb.length() -1);
            }
        }
    }
