    public List<String> generateParenthesis(int n) {
        if(n < 1){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        backtracking(result, "", 0,0, n);
        return result;
    }
    public void backtracking(List<String> result, String s, int open, int close, int max){
        if(s.length() == max *2){
            result.add(s);
            return; 
        }
        if(open < close){
            return;
        }
        if(open < max){
            backtracking(result, s+ "(", open+1, close, max);       
        }
        if(close < max){
            backtracking(result, s+ ")", open, close+1, max);       
        }
    }
