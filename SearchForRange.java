/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
//The time complexity seems to be O(n) instea of O(log n)
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
    public int[] binarySearch(int[] nums, int target, int start, int end){
        int[] result=new int[2];
        result[0]=-1;
        result[1]=-1;
        if(start>end) return result;
        if(start==end) {
            if(nums[start]!=target) return result;
            result[0]=start;
            result[1]=end;
            return result;
        }
        int mid=start+(end-start)/2;
        if(nums[mid]<target) return binarySearch(nums,target,mid+1,end);
        if(nums[mid]>target) return binarySearch(nums,target,start,mid-1);
        int[] left=binarySearch(nums,target,start,mid-1);
        int[] right=binarySearch(nums,target,mid+1,end);
        result[0]=left[0]==-1?mid:left[0];
        result[1]=right[0]==-1?mid:right[1];
        return result;
    }
}
