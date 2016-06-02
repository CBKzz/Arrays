  /*
  Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
*/
  
  public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> set=new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-2){
            if(nums[i]>0) break;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0) set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                if(sum<=0) while(nums[j]==nums[++j]&&j<k);
                if(sum>=0) while(nums[k]==nums[--k]&&j<k);
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return set;
  }
  
  /*
  Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
  */
  public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int min_sum=0;
        int i=0;
        while(i<nums.length-2){
            int j=i+1;
            int k=nums.length-1;
            if(nums[i]>=target&&target>=0) {
                return min>Math.abs(nums[i]+nums[j]+nums[k]-target)?nums[i]+nums[j]+nums[k]:min_sum;
            }
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target) return sum;
                int diff = Math.abs(sum - target);
                if(diff < min) {
                    min_sum = sum;
                    min = diff;
                }
                if(sum>target) while(nums[k]==nums[--k]&&j<k);
                else while(nums[j]==nums[++j]&&j<k);
            }
            while(nums[i]==nums[++i]&&i<nums.length-2);
        }
        return min_sum;
    }
