container with most water
trapping rain water(也可以使用单调栈)
都可以使用 短板原理 比较 比较较短一边 再向一边移动 
Largest Rectangle in Histogram 也可以单调栈 tbd

#5longest palidrome substring  从中间向两边扩展 并取 low index 和 maxLen 最后返回substring  ababb -> aba 或者 bab

maximum subarray 初始化cur,max 为0, min 看该数如果加上前面一段会不会变大
best time to buy sell 可以由max subarray 改变 计算profit的best 如果profit为负 就赋值为0 所以initial的值都为0
subarray sum equals to k preSum 双指针O(n2), presum + hashmap 类似twosum O(n) 注意 initial put(0,1)

minimum size subarray sum 窗口类 指针移动  不同于 sliding window
他要找一个满足窗口的大小 
时间复杂度为O(2n) 因为内层循环的j不归零 ij 在一直向前走, j最终只会便利一次 i也最终便利一次
for(int i->n){
  while(j<n){
    if() // 满足
      j++//更新 j状态
    else{//不满足
     break;
    }
  }
  更新状态
}

sliding window 会告诉你窗口大小 k
#3longest substring without repeating characets abcabcbb -> abc 
使用set记录, 或者 map记录 index 再找 最近的重复数字 往后一位继续, map可以换成 array字典
minimum window substring
longest-substring-with-at-most-two-distinct-characters/
438Find all anagram in a string sliding window+ hashtable
 
242valid anagram 先问清 输入包含哪些? ascaii? 大小写? unicode要更大一个范围 使用array 做hashmap
49 group anagram
 
56MergeInterval 排序之后 设置 start end 如果新的start 比end 小, end更新为较大值. 其他情况时再加入result 记住加入最后一组值
57InsertInterval 遍历区间 找到插入点 一边合并 新区间 最后再插入, 也可以 先找到插入点 插入后在合并 
MeetingRoomsi 判定能否参加会议  排序(start)找交集
MeetingRoomsii 扫描线算法 对start end都排序 


21MergeTwoSortedList 设置dummy Node 然后 链接较小节点 小心节点为null
23MergeKSortedList 
88Merge Sorted Array [4 5 6 0 0 0] [1 2 3] -> 从末尾的数开始往前比较 注意比较完成后 要再以短数组继续遍历
Lintcode merge sorted interval list



347 topk frequent numbers 692 topk frequent words bucket sort, priorityqueue, TreeMap
451. Sort Characters By Frequency 直接使用最大堆或者bucket sort

kthlargest priorityqueue, quickselect
kth smallets in a matrix





