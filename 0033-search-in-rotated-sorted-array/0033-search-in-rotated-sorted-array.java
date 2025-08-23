class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        // Find the index of the smallest element using binary search
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] > nums[end]) {
                // Pivot is in the right half
                start = mid + 1;
            } else {
                // Pivot is in the left half or the array is already sorted
                end = mid;
            }
        }
        
        // At this point, 'start' is the index of the smallest element
        int pivot = start;
        
        // Reset pointers for the actual search
        start = 0;
        end = nums.length - 1;
        
        // Decide which half to search based on target value
        if (target >= nums[pivot] && target <= nums[end]) {
            // Search in right half
            start = pivot;
        } else {
            // Search in left half
            end = pivot - 1;
        }
        
        // Perform regular binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1; // Target not found
    }
}