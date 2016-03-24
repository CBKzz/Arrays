/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.
*/

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        int first=nums[0];
        int second=-1;
        int cur=1;
        for(int i=1;i<nums.length;i++){
            if(cur==1){
                if(nums[i]>first) {second=nums[i];cur=2;}
                else first=nums[i];
            }
            else {
                if(nums[i]>second) return true;
                if(nums[i]<=second&&nums[i]>first) second=nums[i];
                else first=nums[i];
            }
        }
        return false;
    }
}
