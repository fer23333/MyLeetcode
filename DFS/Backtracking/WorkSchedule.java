package com.company;
import java.util.*;
public class WorkSchedule {
    public static void main(String[] args) {
        String s= "?????88";
        int work_hours = 50;int day_hours= 8;
        String[] str = new WorkSchedule().findSchedules(work_hours,day_hours, s);
        for(String n : str){
            System.out.println(n);
        }

    }
    public static String[] findSchedules(int work_hours, int day_hours, String pattern){
        if(pattern == null || pattern.length() == 0) return null;
        List<String> res = new ArrayList<>();
        int hours = work_hours; int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i< pattern.length();i ++){
            if(pattern.charAt(i) - '?' != 0){
                //not "?" character fixed hours
                map.put(i, pattern.charAt(i)- '0');
                hours -= pattern.charAt(i) - '0';
            }
        }
         count = 7- count;
        StringBuilder sb = new StringBuilder();
        backtracking(res, sb, hours, day_hours,count,0,map );

        String[] result = new String[res.size()];
        for(int i =0; i< res.size(); i++){
            result[i] = res.get(i);
        }
        return result;

    }
    public static void backtracking(List<String> res, StringBuilder sb,
                                    int hours, int max, int count,
                                    int day, Map<Integer, Integer> map){
        if(day == 7){
            if(hours == 0){
                res.add(sb.toString());
            }
            return;
        }
        if(map.containsKey(day)){
            sb.append(String.valueOf(map.get(day)));
            backtracking(res, sb, hours,max, count,day + 1,map);
            sb.deleteCharAt(sb.length() -1);
        }
        else{
            for(int i =0; i<= max; i++){
                if( (hours - i)> max*(count -1)){
                    continue;
                }
                sb.append(i);
                backtracking(res, sb, hours -i,max,count -1, day+1, map);
                sb.deleteCharAt(sb.length() -1);
            }
        }

    }
}
