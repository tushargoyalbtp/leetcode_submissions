class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        if (points.length <= 2) {
            return points.length;
        }

        int result = 0;
        int n = points.length;

        for(int i = 0; i<n ; i++){
            HashMap<Double, Integer> angleCount = new HashMap<>();

            int samePoint = 1;
            int samex = 0;
            int max = 0;

            for(int j = 0; j<n; j++){
                if(j==i){
                    continue;
                }

                double dy = points[j][1] - points[i][1];
                double dx = points[j][0] - points[i][0];

                if(dx == 0 && dy == 0){
                    samePoint++;
                } else if (dx == 0){
                    samex++;
                }
                else {
                    double angle = Math.atan2(dy, dx);
                    angleCount.put(angle, angleCount.getOrDefault(angle, 0)+1);
                    max = Math.max(max, angleCount.get(angle));
                }                
            }

            max = Math.max(max, samex);
            result = Math.max(result, max+samePoint);
        }


        return result;
        // for (int i = 0; i < n; i++) {

        //     for (int j = i + 1; j < n; j++) {
        //         int dy = points[j][1] - points[i][1];
        //         int dx = points[j][0] - points[i][0];

        //         int count = 2;
        //         for (int k = 0; k < n; k++) {

        //             if (k != i && k != j) {
        //                 int dy_s = points[k][1] - points[i][1];
        //                 int dx_s = points[k][0] - points[i][0];

        //                 if (dy * dx_s == dy_s * dx) {
        //                     count++;
        //                 }
        //             }
        //         }

        //         result = Math.max(result, count);
        //     }
        // }

        // return result;
    }
}