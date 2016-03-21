/*
This problem here is that we have several pairs of time, start and end. Let's combine the intervals that can overlap
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result=new ArrayList<>();
        Map<Integer, Integer> map=new TreeMap();
        for(Interval intv:intervals){
            if(!map.containsKey(intv.start)) map.put(intv.start,intv.end);
            else {if(map.get(intv.start)<intv.end) map.put(intv.start,intv.end);}
        }
        if(intervals==null||intervals.size()==0) return result;
        int i=0;
        int start=0;
        int end=0;
        for(int key:map.keySet()){
            if(i==0){
                start=key;
                end=map.get(key);i++;
            }
            else{
                if(key>end){
                    Interval temp=new Interval(start,end);
                    result.add(temp);
                    start=key;
                    end=map.get(key);
                }
                else end=Math.max(end,map.get(key));
            }
        }
        Interval temp=new Interval(start,end);
        result.add(temp);
        return result;
        
    }
}

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

I don't know why we have to give a sorted result. It would be much easier to write if we can give an unsorted one.
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result=new ArrayList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        if(intervals==null||intervals.size()==0) {
            result.add(newInterval);
            return result;
        }
       int start=newInterval.start;
       int end=newInterval.end;
       boolean flag=true;
       for(Interval intv: intervals){
           if(intv.end<newInterval.start||intv.start>newInterval.end) {
               if(intv.start>newInterval.end&&flag) {flag=false;result.add(new Interval(start,end));}
               result.add(intv);
           }
           else{
               start=Math.min(start,intv.start);
               end=Math.max(end,intv.end);
           }
       }
       if(flag) result.add(new Interval(start,end));
       return result;
    }
}

/*
Here comes the fun:
if we want to pick out all the intervals that overlaps with other intervlas?
*/
I think there are actually two kinds of questions about: to find out the exact pair of overlap(two intervals), we can do this brute force, in n^2. Actually, this might be the only way to do.
Another quesiton is just get a set of this intervals, and we don't need to care which interval pairs with which one. We can do this using sort and then linear compare in O(n) time. 
public class solution{
public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result=new ArrayList<>();
        Map<Integer, Integer> map=new TreeMap<>();
        for(Interval intv:intervals){
            if(!map.containsKey(intv.start)) map.put(intv.start,intv.end);
            else{
                if(map.get(intv.start)>intv.end) result.add(intv);
                else {
                    result.add(new Interval(intv.start,map.get(intv.start)));
                    map.put(intv.start,intv.end);
                }
            }
        }
        System.out.println(map.toString());
        int start=-1;
        int end=-1;
        boolean first=true;
        for(int i:map.keySet()){
                //no overlap
                if(i>end){
                    start=i;
                    end=map.get(i);
                    first=true;
                }
                //overlap
                else{
                	if(first) {
                		result.add(new Interval(start,end));
                		first=false;
                	}
                	result.add(new Interval(i,map.get(i)));
                    end=Math.max(end,map.get(i));
                }
        }
        return result; 
    }
}
