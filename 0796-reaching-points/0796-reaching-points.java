class Solution {
    
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // pick or not pick strategy


        // if(sx > tx || sy > ty){
        //     return false;
        // }

        // if(sx == tx && sy == ty){
        //     return true;
        // } 

        // return reachingPoints(sx+sy, sy, tx, ty) || reachingPoints(sx, sx+sy, tx, ty);


        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) return true;

            if (tx > ty) {
                if (ty > sy)
                    tx %= ty;
                else
                    return (tx - sx) % ty == 0;
            } else {
                if (tx > sx)
                    ty %= tx;
                else
                    return (ty - sy) % tx == 0;
            }
        }
        return false;
    }
}


// sx + sy = tx;
// sy = ty;

// sx = tx-ty;


// sx = tx;
// sx + sy = ty;

// sy = ty-tx;