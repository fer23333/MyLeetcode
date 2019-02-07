给出两个输入流inputA和inputB(包含退格符),如果两个输入流最后的结果相等，输出YES，否则输出NO。
利用栈的思想即可

    public String inputStream(String inputA, String inputB) {
        // Write your code here
        Deque<Character> stackA = new ArrayDeque<>();
        Deque<Character> stackB = new ArrayDeque<>();
        for(Character c : inputA.toCharArray()){
            if(c != '<'){
                stackA.push(c);
            }else{
                if(!stackA.isEmpty()){
                    stackA.pop();
                }else{
                    continue;
                }
            }
        }
        for(Character c : inputB.toCharArray()){
            if(c != '<'){
                stackB.push(c);
            }else{
                if(!stackB.isEmpty()){
                    stackB.pop();
                }else{
                    continue;
                }
            }
        }
        while(!stackA.isEmpty() && !stackB.isEmpty()){
            if(stackA.pop() != stackB.pop()){
                return "NO";
            }
        }
        if(stackA.size() != stackB.size()){
            return "NO";
        }
        return "YES";
    }
