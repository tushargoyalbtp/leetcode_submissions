class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ansList = new ArrayList<>();

        helper(candidates, 0, target, ansList, new ArrayList<>());

        return ansList;
    }

    public void helper(int[] candidates,
                       int index,
                       int target,
                       List<List<Integer>> ansList,
                       List<Integer> subList) {

        // Found a valid combination
        if (target == 0) {
            ansList.add(new ArrayList<>(subList));
            return;
        }

        // Out of bounds
        if (index == candidates.length) {
            return;
        }

        // PICK current element
        if (candidates[index] <= target) {
            subList.add(candidates[index]);

            // stay at same index because we can reuse the number
            helper(candidates,
                   index,
                   target - candidates[index],
                   ansList,
                   subList);

            // backtrack
            subList.remove(subList.size() - 1);
        }

        // NOT PICK current element
        helper(candidates,
               index + 1,
               target,
               ansList,
               subList);
    }
}


// [2,3,6,7] , target -> 7

// Sort an array first

// 2 , target -> 7-2 -> 5
// search less than target 
// 2,3 -> 
// if 2 , target -> 5-2 = 3 , 
//     3, target -> 3-3 = 0
//     result -> [2,2,3]

// else 3, target -> 5-3 = 2
//     2, target -> 5-2 = 3

//     result -> [2,3,2]



//     note : check if the remaining target value is present in an array or not?
