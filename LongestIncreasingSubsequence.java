/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

public class Solution {
    /* O(n^2)
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0||nums==null) return 0;
        int[] max=new int[nums.length];
        Arrays.fill(max,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) max[i]=Math.max(max[j]+1,max[i]);
            }
        }
        int result=0;
        for(int i=0;i<nums.length;i++){
            result=Math.max(max[i],result);
        }
        return result;
    }
    */
    public int lengthOfLIS(int[] nums){
        List<Integer> list=new ArrayList<>();
        for(int n:nums){
            if(list.isEmpty()||n>list.get(list.size()-1)) {list.add(n);continue;}
            int po=Collections.binarySearch(list,n);
            if(po<0) list.set(-1-po,n);
        }
        return list.size();
    }
}
