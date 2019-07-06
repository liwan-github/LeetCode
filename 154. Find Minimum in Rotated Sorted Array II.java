class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] > nums[end]){
                start = mid + 1;
            } else if (nums[mid] < nums[end]){
                end = mid;
            } else {
                end --;
            }
        }
        return nums[start];
    }
}