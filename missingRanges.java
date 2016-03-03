public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result=new ArrayList<>();
        if(nums.length==0){
            String s=upper==lower?lower+"":lower+"->"+upper;
            result.add(s);
            return result;
        }
        if(nums[0]!=lower){
            String s=lower==nums[0]-1?lower+"":lower+"->"+(nums[0]-1);
            result.add(s);
            lower=nums[0];
        }
        for(int i=1;i<nums.length;i++){
            int a=nums[i]-nums[i-1];
            if(a>1) {
                String s=a==2?nums[i-1]+1+"":nums[i-1]+1+"->"+(nums[i]-1);
                result.add(s);
            }
        }
        if(upper!=nums[nums.length-1]) {
                String s=nums[nums.length-1]==upper-1?upper+"":nums[nums.length-1]+1+"->"+upper;
                result.add(s);
        }
        return result;
    }
}
