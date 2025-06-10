class Solution {
    int result = 0;
    int[][] tree = new int[101][101];
    public int findRotateSteps(String ring, String key) {
        int ans = 0;
        for(int i = 0; i < tree.length; i++){
            for(int j = 0; j < tree.length; j++){
                tree[i][j] = -1;
            }
        }

        return solve(0, 0, ring, key);

    }

    public int solve(int ri, int ki, String ring, String key){

        if(ki >= key.length()){
            return 0;
        }
        int result = Integer.MAX_VALUE;

        if(tree[ri][ki] != -1){
            return tree[ri][ki];
        }

        for(int i = 0; i < ring.length(); i++){
            if(ring.charAt(i) == key.charAt(ki)){
                int steps = 1 + countSteps(i, ri, ring, key);
                int totalSteps = steps + solve(i, ki+1, ring, key);
                result = Math.min(result, totalSteps);
            }
        }
        tree[ri][ki] = result;
        return tree[ri][ki];
    }

    public int countSteps(int i, int ri, String ring, String key){
        int clockwise = Math.abs(ri - i);
        int anticlockwise = ring.length() - clockwise;
        return Math.min(clockwise, anticlockwise);
    }
}