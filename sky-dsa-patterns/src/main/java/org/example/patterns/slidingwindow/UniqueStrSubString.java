package org.example.patterns.slidingwindow;

import java.util.*;

public class UniqueStrSubString {

    public static void main(String[] args) {
        int[] input = {5,7,7,8,8,10};
        int k = 8;
        for (int a: searchRange(input, k)){
            System.out.println(a);
        }
    }

    public static int[] searchRange(int[] nums, int target) {

        int frst = -1;
        int sec = -1;

        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                frst = left;
                sec = right-1;
                break;
            }else if(target < nums[mid]){
                right = mid -1;
            }else {
                left = mid+1;

            }
        }

        return new int[]{frst, sec};
    }
}
