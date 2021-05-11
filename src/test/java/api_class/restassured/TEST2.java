package api_class.restassured;

import java.util.Arrays;

public class TEST2 {

    public static void main(String[] args) {
        int[] arr ={3,5,8,17,28};
        int num =29;
        int result = solution(arr,num);
        System.out.println(result);

    }

    static int solution(int[] A, int X) {

        int N = A.length;
        if (N == 0) {
            return -1;
        }
        Arrays.sort(A);
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                l=m-1;

            } else if(A[m]==X)
            {
                return m;
            }
            else{
                l = m+1;

            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
}

