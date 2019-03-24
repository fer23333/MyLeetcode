// time O(4^n/ sqrt(n) )Each valid sequence has at most n steps during the backtracking procedure.
// space O(4^n/ sqrt(n) )as described above, and using O(n) space to store the sequence. 

//this is the n-th Catalan number which is bounded asymptotically by 4^n/ (sqrt(n)*n)
// 卡特兰数还有那些应用呢?

// 1.括号化 ()() || (()) 这样子滴

// 2.出栈次序(above)

// 3.凸多边形三角划分

// 4.给定结点组成二叉搜索树

// 5.n对括号正确匹配次数

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
					// open == max && close == max
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

n =3
( ( ( ) ) ) (()())  (())() ()(()) ()()() 
open 3 
close 2
close 0
        
