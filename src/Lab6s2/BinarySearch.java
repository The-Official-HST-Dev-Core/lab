package Lab6s2;

public class BinarySearch {
    public long binarySearch(long num, long width, long height ){
        long side=1;
        long maxside = num * Math.max(width,height);
        while (side < maxside) {
            long middle = side + (maxside-side)/2;
            if (fits(middle, num, width, height)){
                maxside = middle;
            }else{
                side = middle+1;
            }
        }
        return side;
    }
    static boolean fits(long side, long num, long width, long height) {
        long colsAm = side / width;
        long rowsAm = side / height;
        if (colsAm == 0 || rowsAm == 0){return false;}
        if (colsAm >= num || rowsAm >= num){return true;}
        return colsAm * rowsAm >= num;
    }
}
