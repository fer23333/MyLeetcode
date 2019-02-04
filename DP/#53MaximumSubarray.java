使用prefixsum 
sum += nums[i] (sum[i]- sum[i-1] =nums[i])

可变为买卖股票i的题

follow up maximum submatrix

Given an n x n matrix of positive and negative integers, find the submatrix with the largest possible sum
Given matrix = 
[
[1,3,-1],
[2,3,-2],
[-1,-2,-3]
]
return 9.
Explanation:
the submatrix with the largest possible sum is:
[
[1,3],
[2,3]
]


submatrix sum
找到和为0的submatrix

将matrix按裂求和压扁成一维array，for循环上下边界，一共有Cn2共n2种可能性
再在一维array中按照subarray sum方法做, O(n)
所以总时间O(n2 x n) = O(n3)
