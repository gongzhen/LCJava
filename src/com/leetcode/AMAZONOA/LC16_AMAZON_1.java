package com.leetcode.AMAZONOA;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

/**
 *
 Amazon’s Sort Center
 In Amazon’s sort center, a computer system decides what packages are to be loaded on what trucks. All rooms and spaces are abstracted into space units which is represented as an integer. For each type of truck, they have different space units. For each package, they will be occupying different space units. As a software development engineer in sort centers, you will need to write a method:

 Given truck space units and a list of product space units, find out exactly TWO products that fit into the truck. You will also implement an internal rule that the truck has to reserve exactly 30 space units for safety purposes. Each package is assigned a unique ID, numbered from 0 to N-1.

 Assumptions:
 You will pick up exactly 2 packages.
 You cannot pick up one package twice.
 If you have multiple pairs, select the pair with the largest package.

 Input:
 The input to the function/method consists of two arguments :
 truckSpace , an integer representing the truck space.
 packagesSpace , a list of integers representing the space units occupying by packages.

 Output:
 Return a list of integers representing the IDs of two packages whose combined space will leave exactly 30 space units on the truck.

 Example
 Input :
 truckSpace = 90
 packagesSpace = [1, 10, 25, 35, 60]
 Output :
 [2, 3]
 Explanation : Given a truck of 90 space units, a list of packages space units [1, 10, 25, 35, 60], Your method should select the third(ID-2) and fourth(ID-3) package since you have to reserve exactly 30 space units.
 *
 */
public class LC16_AMAZON_1 {

    public int[] truckAndLoad(int space, int[] nums) {
        space = space - 30;
        if (space <= 0) {
            return new int[]{};
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length -1;
        List<Integer> list = new ArrayList<>();
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > space) {
                j--;
            } else if (sum < space) {
                i++;
            } else if (sum == space) {
                if (list.size() == 0) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                } else if (list.size() > 0) {
                    if ((nums[i] > list.get(0) && nums[i] > list.get(1))
                            || nums[j] > list.get(0) && nums[j] > list.get(1)) {
                        list.clear();
                        list.add(nums[i]);
                        list.add(nums[j]);
                    }
                }
                i++;
                j--;
            }
        }
        if (list.size() == 2) {
            return new int[]{list.get(0), list.get(1)};
        }
        return new int[]{};
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    private static class Pair {
        int id;
        int val;
        public Pair(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }

    ArrayList<Integer> IDsOfPackages(int truckSpace,
                                     List<Integer> packagesSpace) {
        // WRITE YOUR CODE HERE
        int space = truckSpace - 30;
        if (space <= 0) {
            return new ArrayList<Integer>();
        }

        int size = packagesSpace.size();
        Pair[] packages = new Pair[size];
        for (int i = 0; i < size; i++) {
            packages[i] = new Pair(i, packagesSpace.get(i));
        }

        Arrays.sort(packages, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.val - p2.val;
            }
        });

        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = size - 1;
        while (i < j) {
            int p1 = packages[i].val;
            int p2 = packages[j].val;
            int sum = p1 + p2;
            if (sum > space) {
                j--;
            } else if (sum < space) {
                i++;
            } else if (sum == space) {
                if (result.size() == 0) {
                    result.add(packages[i].id);
                    result.add(packages[j].id);
                } else if (result.size() == 2) {
                    if ((p1 > packages[result.get(0)].val && p1 > packages[result.get(1)].val)
                            || (p2 > packages[result.get(0)].val && p2 > packages[result.get(1)].val)) {
                        result.clear();
                        result.add(packages[i].id);
                        result.add(packages[j].id);
                    }
                }
                i++;
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC16_AMAZON_1 obj = new LC16_AMAZON_1();
        int[] array = new int[]{20, 70, 90, 30, 60, 110};
        List<Integer> list = Arrays.asList(100, 180, 40, 120, 10);
        ArrayList<Integer> result = obj.IDsOfPackages(250, list);
        PrintUtils.printListInteger(result);
    }
}
