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
    /**
     * 252. Meeting Rooms
     */
    public boolean canAttendMeetings(Interval[] intervals) {

        List<Interval> list =  new LinkedList<>();
        for (Interval i : intervals)
            list.add(i);

        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        };
        Collections.sort(list, comparator);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).end > list.get(i + 1).start)
                return false;
        }
        
        return true;
    }
  
  /**
   * 252. Meeting Rooms 
   * Elegant way
   */
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }        
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) return false;
        }
        return true;
    }
    
    /**
     * 253. Meeting Rooms II
     * Greedy.
     */
    public int minMeetingRooms(Interval[] intervals) {

        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        boolean[] used = new boolean[intervals.length];
        
        int count = 0, left = intervals.length;
        while(left > 0) {
            ++count;
            int availableTime = 0;
            for (int i = 0; i < intervals.length; i++) {
                if (!used[i]) {
                    if (intervals[i].start >= availableTime) {
                        used[i] = true;
                        --left;
                        availableTime = intervals[i].end;
                    }
                }
            }
        }
        
        return count;
    }
    
    /**
     * 253. Meeting Rooms II
     * Skyline way.
     */
}
