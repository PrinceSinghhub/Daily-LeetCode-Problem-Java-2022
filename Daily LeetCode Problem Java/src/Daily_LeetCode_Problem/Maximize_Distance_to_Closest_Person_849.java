package Daily_LeetCode_Problem;
//https://leetcode.com/problems/maximize-distance-to-closest-person/
public class Maximize_Distance_to_Closest_Person_849 {
    public static void main(String[] args) {

        int[] seats = {1, 0, 0, 0, 1, 0, 1};
        int ans = MaxDistsnceSeats(seats);
        System.out.println(ans);
    }

    static int MaxDistsnceSeats(int[] seats) {

        int First = 0;
        int Second = 0;

        for (int i = 1; i < seats.length; i++) {
            if (seats[i] == 1 || i == seats.length - 1) {
                int dist = i - First;

                if (seats[First] == 1 && seats[i] == 1) {
                    Second = Math.max(Second, (dist) / 2);
                } else {
                    Second = Math.max(Second, dist);
                }

                First = i;
            }
        }
        return Second;
    }
}