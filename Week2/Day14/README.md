# Day 14, 14/04/2020 - Perform String Shifts

You are given a string `s` containing lowercase English letters, and a matrix `shift`, where `shift[i] = [direction, amount]`:

- `direction` can be `0` (for left shift) or `1` (for right shift).
- `amount` is the amount by which string `s` is to be shifted.
- A left shift by 1 means remove the first character of `s` and append it to the end.
- Similarly, a right shift by 1 means remove the last character of `s` and add it to the beginning.

Return the final string after all operations.

**Example 1**:

<code>
Input: s = "abc", shift = [[0,1],[1,2]]

Output: "cab"

Explanation:<br>
[0,1] means shift to left by 1. "abc" -> "bca"<br>
[1,2] means shift to right by 2. "bca" -> "cab"
</code>

**Example 2**:

<code>
Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]

Output: "efgabcd"

Explanation:<br>
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"<br>
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"<br>
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"<br>
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
</code>

**Constraints**:

- `1 <= s.length <= 100`
- `s` only contains lower case English letters.
- `1 <= shift.length <= 100`
- `shift[i].length == 2`
- `0 <= shift[i][0] <= 1`
- `0 <= shift[i][1] <= 100`

**Hint 1**:

Intuitively performing all shift operations is acceptable due to the constraints.

**Hint 2**:

You may notice that left shift cancels the right shift, so count the total left shift times (may be negative if the final result is right shift), and perform it once.