这道题首先可以用BFS来解，我们先把给定字符串排入队中，然后取出检测其是否合法，若合法直接返回，不合法的话，我们对其进行遍历，
对于遇到的左右括号的字符，我们去掉括号字符生成一个新的字符串，如果这个字符串之前没有遇到过，将其排入队中，
我们用哈希集合记录一个字符串是否出现过。我们对队列中的每个元素都进行相同的操作，直到队列为空还没找到合法的字符串的话，那就返回空集 
 public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            res.add(s);
            return res;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        visited.add(s);
        q.offer(s);
        boolean found = false;
        while(!q.isEmpty()){
            String cur = q.poll();
            if(isValid(cur)){
                res.add(cur);
                found = true;
            }
            if(found){
                continue;
            }
            
            for(int i=0;i< cur.length(); i++){
                if(cur.charAt(i) != '(' && cur.charAt(i) != ')'){
                    continue;
                }
                String str = cur.substring(0,i) + cur.substring(i+1);
                if(!visited.contains(str)){
                    visited.add(str);
                    q.offer(str);
                }
            }
        }
        return res;
    }
    
    public boolean isValid(String s){
        if(s == null || s.length() == 0){
            return true;    
        }
        int open = 0;
        int close = 0;
        for(char c :s.toCharArray()){
            if(open < close){
                return false;
            }else if(c == '('){
                open++;
            }else if( c == ')'){
                close++;
            }
        }
        return open == close;
    }
