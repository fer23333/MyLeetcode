package com.fer;
import java.util.*;

public class WordSquare {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        String[] s = {"area","lead","wall","lady"};
        System.out.println(wordSquare(s));
    }
    public static List<List<String>> wordSquare(String[] s){
        List<List<String>> res = new ArrayList<>();
        dfs(s,res,  new ArrayList<>(), new HashSet<>());
        return res;
    }
    public static void dfs(String[] s, List<List<String>> res, List<String> list, Set<String> set){
        if(list.size() == s.length){
            if(isSquare(list)){
                res.add(new ArrayList<>(list));
            }
        }else{
            for(int i=0; i< s.length; i++){
                if(set.contains(s[i])){
                    continue;
                }
                set.add(s[i]);
                list.add(s[i]);
                dfs(s, res, list, set);
                set.remove(list.get(list.size()-1));
                list.remove(list.size() -1);

            }
        }
    }
    public static boolean isSquare(List<String> s){
        int n = s.size();
        int index = 0;
        for(; index < n; ){
            for(int i= index ; i < n  ; i++){
                if(s.get(i).charAt(index) != s.get(index).charAt(i)){
                    return false;
                }
            }
            index++;
        }
        return true;
    }
}
