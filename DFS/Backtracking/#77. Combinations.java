//两种version
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,n,1,k,new ArrayList());
        return res;
    }
    public void backtrack(List<List<Integer>> res, int n, int num, int k, List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList(list));
            //由于list是一直在变化的 假如res.add(list) 虽然每次加入都有值, 但是由于最后list会清空 所有值也被清空
            //所以需要深拷贝它的值 新建一个list
        }else{
            for(int i = num;i<=n;i++){
                list.add(i);
                backtrack(res,n,i+1,k,list);
                list.remove(list.size()-1);
            }
        }
    }
}


public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,n,1,k,new ArrayList());
        return res;
    }
    public void backtrack(List<List<Integer>> res, int n, int num, int k, List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList(list));
        }else if(num <=n){
            list.add(num);
            backtrack(res,n,num+1,k,list);
            list.remove(list.size()-1);
            backtrack(res,n,num+1,k,list);
        }
    }
}
