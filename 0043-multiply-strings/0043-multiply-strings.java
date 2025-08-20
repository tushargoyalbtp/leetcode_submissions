// class Solution {
//     public String multiply(String num1, String num2) {
        
//         int size1 = num1.length();
        
//         int size2 = num2.length();

//         int[] arr1 = new int[size1];
//         int[] arr2 = new int[size2];

//         for(int i = 0 ; i < size1; i++){
//             int digit = num1.charAt(i) - '0';
//             arr1[i] = digit;
//         }

//         for(int i = 0 ; i < size2; i++){
//             int digit = num2.charAt(i) - '0';
//             arr2[i] = digit;            
//         }
//         int count1 = size1-1;
        
//         long ans1 = 0;

//         for(int i = 0; i < size1; i++){
//             ans1 = ans1 + (long)(arr1[i] * Math.pow(10,count1));
//             count1--;    
//         }

//         int count2 = size2-1;
        
//         long ans2 = 0;

//         for(int i = 0; i < size2; i++){
//             ans2 = ans2 + (long)(arr2[i] * Math.pow(10,count2));
//             count2--;    
//         }

//         return ""+(ans1 * ans2);
//     }
// }



//optimized way
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        // Multiply from right to left
        for (int i = m - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';

                int sum = result[i + j + 1] + d1 * d2;
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        // Build string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.toString();
    }
}