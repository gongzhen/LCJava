package com.leetcode.DP;

import com.leetcode.Helper.PrintUtils;

public class LC152 {

    /**
     * https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
     * The interesting thing about this solution is that it depends not only on a
     * state (the largest product that can be obtained by a sequence ending in the
     * previous number), but two states (the largest and smallest products). A
     * simpler dp problem might just create a dp[] and put the maximum value in it(in
     * this case, the largest product). But this solution show us a new way: Our dp
     * array can store more data than just a single value. The reason why the above
     * solution does not use the dp array is that dp[i] only depends on dp[i - 1] so
     * there is no need to save all the previous max and min data, just save the
     * previous max and min value(dp[i - 1]). The following code uses the custom inner
     * class Tuple so that both imax and imin can be stored, and all imax and imin are
     * stored in the dp array. Although it is a bit more complicated, it helps to deepen
     * understanding.
     * 这道题妙就妙在它不仅仅依赖了一个状态（前一个数所能获得的最大乘积），而是两个状态（最大和最小乘积）。
     * 比较简单的dp问题可能就只是会建立一个dp[]，然后把最大值放到其中。但是这道题给我们打开了新的思路：
     * 我们的dp数组里面可以存更多的信息。而上面的解法之所以没有用dp数组的原因是dp[i]只依赖于dp[i - 1]
     * 因此没有必要把前面所有的信息都存起来，只需要存前一个dp[i-1]的最大和最小的乘积就可以了。下面的代码使用了
     * 自定义的内部类Tuple,从而可以同时存imax和imin,并将所有的imax和imin存到了dp数组中。虽然稍显复杂，但是有助于加深理解。
     *
     *
     *
     */

    class Tuple {
        private int imax;
        private int imin;
        private Tuple(int imax, int imin) {
            this.imax = imax;
            this.imin = imin;
        }
    }

    public int maxProduct(int[] nums) {
        Tuple[] dp = new Tuple[nums.length];
        dp[0] = new Tuple(nums[0],nums[0]);
        int res = dp[0].imax;
        for (int i = 1; i < nums.length; i++) {
            Tuple prev = dp[i - 1];
            int imax = Math.max(Math.max(nums[i], nums[i] * prev.imax) , nums[i] * prev.imin);
            int imin = Math.min(Math.min(nums[i], nums[i] * prev.imax) , nums[i] * prev.imin);
            dp[i] = new Tuple(imax,imin);
            res = Math.max(imax, res);
        }
        return res;
    }

    public static void main(String[] args) {
        LC152 obj = new LC152();
        int res = obj.maxProduct(new int[]{2,3,-2,4});
        PrintUtils.printString("res:" + res);
    }
}
