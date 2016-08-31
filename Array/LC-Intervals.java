public class Solution {

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
}
