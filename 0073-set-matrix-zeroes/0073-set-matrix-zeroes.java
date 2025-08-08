class Solution {
    public void setZeroes(int[][] matrix) {
        int rowlength = matrix.length;

        int collength = matrix[0].length;
        
        boolean[][] visited = new boolean[rowlength][collength];



        for(int i = 0 ; i < rowlength; i++){
            for(int j = 0; j < collength; j++){
                if(matrix[i][j] == 0 && !visited[i][j]){
                    for(int k = 0; k < rowlength; k++){
                        if(!visited[k][j] && matrix[k][j] != 0){
                            matrix[k][j] = 0;
                            visited[k][j] = true;
                        }
                    }
                    for(int k = 0; k < collength; k++){
                        if(!visited[i][k] && matrix[i][k] != 0){
                            matrix[i][k] = 0;
                            visited[i][k] = true;
                        } 
                    }
                }
            }
        }
    }
}