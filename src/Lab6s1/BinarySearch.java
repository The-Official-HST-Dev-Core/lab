package Lab6s1;

import java.util.List;

public class BinarySearch {
    public int binarySearch(List<Integer> list, int searchFor){
        if (list == null || list.isEmpty()){ return 0; }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == searchFor) return list.get(mid);
            if (list.get(mid) < searchFor){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        if (right < 0){
            return list.get(0);
        }
        if (left >= list.size()){
            return list.get(list.size()-1);
        }

        int leftVal  = list.get(right);
        int rightVal = list.get(left);
        if (Math.abs(leftVal-searchFor) <= Math.abs(rightVal-searchFor)){
            return leftVal;
        }else{
            return rightVal;
        }
    }
}
