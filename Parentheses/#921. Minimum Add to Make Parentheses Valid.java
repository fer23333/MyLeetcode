//可以使用栈 也可以使用临时变量代替
//如果遇到'(' 推入栈, 如果遇到')' 而且栈不为空 pop, 如果为空 counter++, 最后counter加上栈的size. 
//也可以使用两个变量代替栈 减少空间复杂度
public int minAddToMakeValid(String S) {
        if(S == null || S.length() == 0){
            return 0;
        }
        Deque<Character> stack = new ArrayDeque<>();
        int counter = 0;
        for(char c : S.toCharArray()){
            if(c == '('){
                stack.push('(');
            }else if(c == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    counter++;
                }
            }
        }
       
        return stack.size() + counter;
        
    }
