class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            System.out.println(m);
            if (nums[m] == target)
                return m;
            else if (target < nums[m])
                r = m - 1;
            else
                l = m + 1;

        }
        return -1;
    }

    public int binary_search(int l, int r, int[] nums, int target) {
        if (l > r) return -1;
        int m = l + (r - 1) / 2;

        if (nums[m] == target) return m;
        return (nums[m] < target) ?
            binary_search(m + 1, r, nums, target) :
            binary_search(l, m - 1, nums, target);
        
    }

    public int search_recurisve(int[] nums, int target) {
        return binary_search(0, nums.length - 1, nums, target);
    }
}
