/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        int[] s=new int[airplanes.size()];
        int[] e=new int[airplanes.size()];
        for(int i=0;i<airplanes.size();i++){
            s[i]=airplanes.get(i).start;
            e[i]=airplanes.get(i).end;
        }
        Arrays.sort(s);
        Arrays.sort(e);
        int num=0;//用最少的消息表式
        int max=0;
        for(int i=0,j=0;i<s.length;){//并不需要记录区分那架飞机，只需知道有几架就行了
            if(s[i]<e[j]){
                i++;
                num++;
                max=Math.max(max,num);
            }else{
                j++;
                num--;
            }
        }
        return max;
    }
}
