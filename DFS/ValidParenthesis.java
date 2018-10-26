//用栈 放反向的括号 要求是严格的括号放法()[] not ([)]

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(Character c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();

        
    }
