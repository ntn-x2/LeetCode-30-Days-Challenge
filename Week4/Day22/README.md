# Day 22, 22/04/2020 - Subarray Sum Equals K

Given an array of integers and an integer `k`, you need to find the total number of continuous subarrays whose sum equals to `k`.

**Example 1**:

<code>
Input:nums = [1,1,1], k = 2

Output: 2
</code>

**Note**:

1. `1 <= nums.length <= 20,000`.
2. `-1000 <= nums[i] <= 1000` and `-1e7 <= k <= 1e7`.

**Hint 1**:

Will Brute force work here? Try to optimize it.

**Hint 2**:

Can we optimize it by using some extra space?

**Hint 3**:

What about storing sum frequencies in a hash table? Will it be useful?

**Hint 4**:

`sum(i,j) = sum(0,j) - sum(0,i)`, where `sum(i,j)` represents the sum of all the elements from index `i` to `j-1`. Can we use this property to optimize it.