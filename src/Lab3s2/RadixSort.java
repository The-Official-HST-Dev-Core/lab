import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import SortInterface.*;


public class RadixSort implements Sorting<BigInteger>{
    @Override
    public void sort(List<BigInteger> nums) {
        if(nums.size()<=1){
            return;
        }

        BigInteger max=nums.get(0);
        for (int i=1;i<nums.size();i++){
            if(nums.get(i).compareTo(max)>0){
                max=nums.get(i);
            }
        }

        int maximum = max.toString().length();
        List<List<BigInteger>> trash = new ArrayList<>();
        for (int j =0; j<10;j++) {
            trash.add(new ArrayList<>());
        }

        for (BigInteger k = BigInteger.ONE; k.compareTo(max) <= 0; k = k.multiply(BigInteger.TEN)) {
            for(int counteerrrr=0; counteerrrr<nums.size();counteerrrr++){
                int digit = ((nums.get(counteerrrr).divide(k)).mod(BigInteger.TEN).intValue());
                trash.get(digit).add(nums.get(counteerrrr));

            }

            nums.clear();

            for(int counnnterrrrrrrr =0; counnnterrrrrrrr<10;counnnterrrrrrrr++){
                for(int canteen =0; canteen<trash.get(counnnterrrrrrrr).size();canteen++){
                    nums.add(trash.get(counnnterrrrrrrr).get(canteen));
                }
            }

            for(int imtiredboss = 0; imtiredboss<10; imtiredboss++){
                trash.get(imtiredboss).clear();
            }

        }
    }
}