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
}
