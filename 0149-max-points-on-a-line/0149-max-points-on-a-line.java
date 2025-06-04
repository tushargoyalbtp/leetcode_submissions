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
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                int dy = points[j][1] - points[i][1];
                int dx = points[j][0] - points[i][0];

                int count = 2;
                for (int k = 0; k < n; k++) {

                    if (k != i && k != j) {
                        int dy_s = points[k][1] - points[i][1];
                        int dx_s = points[k][0] - points[i][0];

                        if (dy * dx_s == dy_s * dx) {
                            count++;
                        }
                    }
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }
}