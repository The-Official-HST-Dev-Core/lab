import java.util.Arrays;

public class Lab2{
    static void main() {
        Lab2 program = new Lab2();
        int array[]={1,2,5,3,3,3,9,3,8,3,3,5,4}; //12554
        System.out.println(program.removeElementInPlace(array,3));
    }
    public boolean removeElementInPlace(int[] arr, int val){
        int nvalAssassinTargs = 0;
        for (int i =0; i<arr.length; i++){
            if (arr[i]!=val){
                arr[nvalAssassinTargs]=arr[i]; // literal mindfuckery
                nvalAssassinTargs++;
            }
        }
        for (int i = 1; i<=(arr.length-nvalAssassinTargs);i++){
            arr[arr.length-i]=0;
        }
        System.out.printf("Targets killed: %d\n", (arr.length-nvalAssassinTargs));
        System.out.printf("Non-targets: %s\n", Arrays.toString(arr));
        return true;
    }


}