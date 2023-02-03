package Daily_LeetCode_Problem;

import java.util.Arrays;

//todo v.v.v.v.v.v imp question ask in MNC
public class Gas_Station_134 {
    public static void main(String[] args) {


        int[] gas = {3,1,1};
        int[] cost = {1,2,2};

        int ans = FindIndex(gas,cost);
        System.out.println(ans);
    }

    static int FindIndex(int[] gas, int[] cost) {

        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum+=gas[i];
            costSum+=cost[i];
        }
        if(gasSum<costSum){
            return -1;
        }
        else{
            int[] difference = new int[gas.length];
            for (int i = 0; i < gas.length; i++) {
                difference[i] = gas[i]-cost[i];
            }

            int[] PrifixArray = new int[gas.length];
            int count = 0;
            for(int index:difference){

                int l = count-1;
                if(l >= 0){
                    int add = PrifixArray[l];

                    PrifixArray[count] = add+index;
                    count++;
                }
                else {
                    PrifixArray[count] = index;
                    count++;
                }
            }

            int min = 0;
            for(int index:PrifixArray){
                if(index<=min){
                    min = index;
                }
            }
            System.out.println(Arrays.toString(difference));
            System.out.println(Arrays.toString(PrifixArray));
            for (int i = 0; i < PrifixArray.length; i++) {
                if(PrifixArray[i] == min){
                    int ans = i+1;

                    if(ans == PrifixArray.length){
                        return 0;
                    }
                    else {
                        return ans;
                    }
                }
            }
        }

        return 0;
    }
}
