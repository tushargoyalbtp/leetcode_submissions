class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        StringBuilder sb = new StringBuilder();

        // Use long to avoid overflow
        long num = (long) numerator;
        long den = (long) denominator;

        // Handle the sign
        if ((num < 0) ^ (den < 0)) {
            sb.append("-");
        }

        num = Math.abs(num);
        den = Math.abs(den);

        long q = num / den;
        long r = num % den;

        sb.append(q);
        if (r == 0) {
            return sb.toString();
        } else {
            sb.append(".");
            HashMap<Long, Integer> map = new HashMap<>();

            while (r != 0) {
                if (map.containsKey(r)) {
                    int len = map.get(r);
                    sb.insert(len, "(");
                    sb.append(")");
                    break;
                }

                else {
                    map.put(r, sb.length());
                    r *= 10;
                    q = r / den;
                    r = r % den;
                    sb.append(q);
                }
            }
        }

        return sb.toString();
    }
}