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

}

