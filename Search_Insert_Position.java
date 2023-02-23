class Solution {
   public int searchInsert(int[] nums, int target) {
    int res = 0, l = 0, h = nums.length - 1;
    while (l <= h) {
        int mid = l + (h - l) / 2;

        if (target > nums[mid]) {
            l = mid + 1;
            res = mid + 1;
        } else if (target < nums[mid]) {
            h = mid - 1;
            res = mid;
        } else {
            res = mid;
            break;
        }
    }
    return res;
}
}