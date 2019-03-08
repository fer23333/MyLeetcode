container with most water
trapping rain water(也可以使用单调栈)
都可以使用 短板原理 比较 比较较短一边 再向一边移动 
Largest Rectangle in Histogram 也可以单调栈 tbd

#5longest palidrome substring  从中间向两边扩展 并取 low index 和 maxLen 最后返回substring  ababb -> aba 或者 bab


maximum subarray sum
subarray sum equals to k

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
 
 
 56MergeInterval 排序之后 设置 start end 如果新的start 比end 小, end更新为较大值. 其他情况时再加入result 记住加入最后一组值
 MeetingRoomsi
 MeetingRoomsii
 
 
 21MergeTwoSortedList 设置dummy Node 然后 链接较小节点 小心节点为null
 23MergeKSortedList 
 88Merge Sorted Array







