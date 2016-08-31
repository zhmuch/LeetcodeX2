public class Solution {
    
    /**
     * LC056. Merge Intervals
     * 
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comparator);
        
        for (Interval i : intervals) {
            if (res.size() == 0)
                res.add(i);
            else {
                Interval last = res.get(res.size() - 1);
                if (last.end < i.start)
                    res.add(i);
                else
                    last.end = Math.max(last.end, i.end);
            }
        }
        
        return res;
    }
    
    
    
    /**
     * LC057. Insert Interval
     *
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;
        
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval); // add the union of intervals we got
        
        // add all the rest
        while (i < intervals.size()) result.add(intervals.get(i++)); 
        
        return result;
    }
}
