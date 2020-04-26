# Day 26, 26/04/2020 - Longest Common Subsequence

Given two strings `text1` and `text2`, return the length of their longest common subsequence.

A *subsequence* of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A *common subsequence* of two strings is a subsequence that is common to both strings.

If there is no common subsequence, return 0.

**Example 1**:

<code>
Input: text1 = "abcde", text2 = "ace" 

Output: 3  

Explanation: The longest common subsequence is "ace" and its length is 3.
</code>

**Example 2**:

<code>
Input: text1 = "abc", text2 = "abc"

Output: 3

Explanation: The longest common subsequence is "abc" and its length is 3.
</code>

**Example 3**:

<code>
Input: text1 = "abc", text2 = "def"

Output: 0

Explanation: There is no such common subsequence, so the result is 0.
</code>

**Constraints**:

- `1 <= text1.length <= 1000`
- `1 <= text2.length <= 1000`
- The input strings consist of lowercase English characters only.

**Hint 1**:

Try dynamic programming. `DP[i][j]` represents the longest common subsequence of `text1[0 ... i]` & `text2[0 ... j]`.

**Hint 2**:

`DP[i][j] = DP[i - 1][j - 1] + 1`, if `text1[i] == text2[j]`.

`DP[i][j] = max(DP[i - 1][j], DP[i][j - 1])`, otherwise.