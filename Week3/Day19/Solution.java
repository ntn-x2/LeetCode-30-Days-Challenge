class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        } else if (startIndex == endIndex) {
            return nums[startIndex] == target ? startIndex : -1;
        }

        int middleIndex = startIndex + ((endIndex - startIndex) / 2);
        int middleValue = nums[middleIndex];

        if (middleValue == target) {
            return middleIndex;
        }

        int startValue = nums[startIndex];
        int endValue = nums[endIndex];

        if (startValue <= endValue) {           // Normally sorted
            if (middleValue >= target) {
                return search(nums, target, startIndex, middleIndex-1);
            } else {
                return search(nums, target, middleIndex+1, endIndex);
            }
        } else {                                            // There is a rotation somewhere
            int searchResult = search(nums, target, startIndex, middleIndex-1);
            searchResult = searchResult == -1 ? search(nums, target, middleIndex+1, endIndex) : searchResult;
            return searchResult;
        }
    }
}