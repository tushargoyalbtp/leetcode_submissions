class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicates = 1;  // Count the current point itself

            for (int j = i + 1; j < points.length; j++) {
                // Handle duplicate points
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    duplicates++;
                } 
                else {
                    int dx = points[j][0] - points[i][0];
                    int dy = points[j][1] - points[i][1];

                    int gcd = getGCD(dx, dy);
                    dx /= gcd;
                    dy /= gcd;

                    // Normalize direction: ensure dx is positive
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }

                    String slope = dy + "/" + dx;
                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                }
            }

            int currentMax = 0;
            for (int count : slopeMap.values()) {
                currentMax = Math.max(currentMax, count);
            }

            // Add duplicates to the current maximum
            maxPoints = Math.max(maxPoints, currentMax + duplicates);
        }

        return maxPoints;
    }

    // Helper function to compute GCD
    private int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}