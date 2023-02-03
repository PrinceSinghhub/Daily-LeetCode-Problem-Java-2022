package Daily_LeetCode_Problem;

public class Koko_Eating_Bananas_875 {
    public static void main(String[] args) {

        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int ans = findMinHourse(piles, h);
        System.out.println(ans);
    }

    static int findMinHourse(int[] piles, int h) {

        int max = maxElement(piles);

        if (h == piles.length) {
            return max;
        }
        int start = 0;
        int end = max;
        int speed = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPossible(piles, h, mid) == true) {
                speed = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return speed;
    }

    static int maxElement(int[] piles) {

        int max = piles[0];
        for(int i:piles){
            if(i>max){
                max=i;
            }
        }
        return max;
    }

    static boolean isPossible(int[] arr, int h, int mid) {
        int time = 0;
        for (int i = 0; i < arr.length; i++) {
            time += (int) Math.ceil(arr[i] * 1.0 / mid);
        }
        return time <= h;
    }
}