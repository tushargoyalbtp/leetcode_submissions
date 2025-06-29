// class Solution {
//     public int search(int[] nums, int target) {
//         //     int ans = 0;
//         // int i = 0;
//         // if (nums.length == 0) {
//         //     return -1;
//         // }

//         // if (nums.length == 1 && nums[0] == target) {
//         //     return 0;
//         // }
//         // if (nums.length == 1 && nums[0] != target) {
//         //     return -1;
//         // }

//         // for (i = 0; i < nums.length - 1; i++) {

//         //     if (nums[i] > nums[i + 1]) {
//         //         break;
//         //     } else if (nums[i] == target) {
//         //         return i;
//         //     }
//         // }

//         // for (int k = i; k < nums.length; k++) {
//         //     if (nums[k] == target) {
//         //         return k;
//         //     }
//         // }

//         // return -1;
//         // // }

//        if (nums == null || nums.length == 0) {
//             return -1;
//         }
        
//         int start = 0;
//         int end = nums.length - 1;
        
//         while (start <= end) {
//             int mid = start + (end - start) / 2;
            
//             if (nums[mid] == target) {
//                 return mid;
//             }
            
//             // Check if left half is sorted
//             if (nums[start] <= nums[mid]) {
//                 // Check if target is in left half
//                 if (target >= nums[start] && target < nums[mid]) {
//                     end = mid - 1;
//                 } else {
//                     start = mid + 1;
//                 }
//             } 
//             // Right half is sorted
//             else {
//                 // Check if target is in right half
//                 if (target > nums[mid] && target <= nums[end]) {
//                     start = mid + 1;
//                 } else {
//                     end = mid - 1;
//                 }
//             }
//         }
        
//         return -1;
//     }
// }


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