package com.leetcode.Array;

public class LC1007 {

    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A[0], A, B, n);
        // If one could make all elements in A or B equal to A[0]
        if (rotations != -1) {
            return rotations;
        }
            // If one could make all elements in A or B equal to B[0]
        else {
            return check(B[0], A, B, n);
        }
    }

    public int check(int x, int[] A, int[] B, int n) {
        // how many rotations should be done
        // to have all elements in A equal to x
        // and to have all elements in B equal to x
        int rotations_a = 0, rotations_b = 0;
        for (int i = 0; i < n; i++) {
            // rotations coudn't be done
            if (A[i] != x && B[i] != x) {
                return -1;
            }
                // A[i] != x and B[i] == x
            else if (A[i] != x) {
                rotations_a++;
            }
                // A[i] == x and B[i] != x
            else if (B[i] != x) {
                rotations_b++;
            }
        }
        // min number of rotations to have all
        // elements equal to x in A or B
        return Math.min(rotations_a, rotations_b);
    }

    public static void main(String[] args) {
        LC1007 obj = new LC1007();
        // obj.minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2});
        obj.minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4});
    }


}
