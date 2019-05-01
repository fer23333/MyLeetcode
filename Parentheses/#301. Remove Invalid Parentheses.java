// 这道题首先可以用BFS来解，我们先把给定字符串排入队中，然后取出检测其是否合法，若合法直接返回，不合法的话，我们对其进行遍历，
// 对于遇到的左右括号的字符，我们去掉括号字符生成一个新的字符串，如果这个字符串之前没有遇到过，将其排入队中，
// 我们用哈希集合记录一个字符串是否出现过。我们对队列中的每个元素都进行相同的操作，直到队列为空还没找到合法的字符串的话，那就返回空集 

// Time complexity:
// 最差情况 第一次 n个数 n个位置, 第二次n-1个数 n个数中找n-1个删除位置... 所以是n*2^n
// T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1)
// time O(n* 2^n) space
 public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            res.add(s);
            return res;
        }
        Set<String> visited = new HashSet<>();
        // 去重 用在 是否加入q, 间接也决定了结果集
        Queue<String> q = new LinkedList<>();

        visited.add(s);
        q.offer(s);
        boolean found = false;
        //found flag用来去重 这一层找到答案后 就只找当前层的答案, 不用继续remove
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

//dfs

private static final char[] PAR = new char[]{'(', ')'};
private static final char[] REV_PAR = new char[]{ ')', '('};
private void remove(String s, List<String>ans, int last_i, int last_j, char[] par){
    int stack = 0, i = last_i, j = last_j;
    for(; i < s.length(); ++i){
        if(s.charAt(i) == par[0]) stack++;
        if(s.charAt(i) == par[1]) stack--;
        if(stack >= 0) continue;
        for(; j <= i; ++j){
            if(s.charAt(j) != par[1]) continue;
            if(j == last_j || s.charAt(j - 1) != par[1]) remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par);
        }
        return;
    }
    String reversed = new StringBuilder(s).reverse().toString();
    if(par[0] == PAR[0]) remove(reversed, ans, 0, 0, REV_PAR);
    else ans.add(reversed);
}

public List<String> removeInvalidParentheses(String s) {
    List<String> ans = new ArrayList<>();
    remove(s, ans, 0, 0, PAR);
    return ans;
}
//只要找到一种符合的情况
//一遍scan找到符合情况 需要删除的左右括号 放到两个stack中

public String remove(String s){
    Deque<Integer> left = new ArrayDeque<>();
    Deque<Integer> right = new ArrayDeque<>();

    for(int i =0; i< s.length(); i++){
        char c = s.charAt(i);
        if(c == '('){
            left.append(i)
        }else if(c == ')'){
            if(!stack.isEmpty()){
                left.pop();
            }else{
                right.push(i);
            }
        }
    }
    Set<Integer> filter = new HashSet<>();
    while(!left.isEmpty() || !right.isEmpty()){
        if(!left.isEmpty()){
            filter.add(left.pop());
        }
        if(!right.isEmpty()){
            filter.add(right.pop());
        }
    }
    StringBuilder sb = new StringBuilder();
    for(int i=0; i< s.length(); i++){
        if(!filter.contains(i)){
            sb.append(s.charAt(i) + "");
        }
    }
    
    return sb.toString();  
}
 

}
