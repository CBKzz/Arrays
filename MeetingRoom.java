public class Solution {
/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
*/
    public int minMeetingRooms(Interval[] intervals) {
        int[] start=new int[intervals.length];
        int[] end=new int[intervals.length];
        int room=0;
        int endd=0;
        for(int i=0;i<intervals.length;i++){
            start[i]=intervals[i].start;
            end[i]=intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i=0;i<intervals.length;i++){
            if(start[i]<end[endd]) room++;
            else endd++;
        }
        return room;
    }
/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
*/
/*
    public boolean canAttendMeetings(Interval[] intervals) {
       if(intervals==null) return true;
       Arrays.sort(intervals,new Comparator<Interval>(){
         public int compare(Interval a, Interval b){
             return a.start-b.start;
         }  
       }); 
       for (int i = 1; i < intervals.length; i++)
       if (intervals[i].start < intervals[i - 1].end)
       return false;

       return true;
    }*/
    public boolean canAttendMeetings(Interval[] intervals){
        int[]start=new int[intervals.length];
        int[]end=new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i]=intervals[i].start;
            end[i]=intervals[i].end;
        }
        int endd=0;
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i=1;i<intervals.length;i++){
            if (start[i]<end[endd]) return false;
            else endd++;
        }
        return true;
    }
/*
each room has a value, we try to arrange these meetings in one room while max the sum of this value
*/
Considering using dynamic programming
use an array to record max for 0,1,..i-1
use an array to record end point for 0,1,..i-1
Assume we have picked the max for 0,1,..i-1 meetings, with the end point 'e'. When we came to ith meeting, we have to choice:
1. do nothing. use i-1: w(i)=w(i-1)
2. add i to the meeting, then we have to find the max j with end[j]<=s[i], use binary search in end array; w(i)=v(i)+w(j);
pick the bigger one
}

