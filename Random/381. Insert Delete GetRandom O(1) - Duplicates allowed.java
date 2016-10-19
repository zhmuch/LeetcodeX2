public class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random random;


    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            map.get(val).add(list.size());
            list.add(val);
        
            return false;
        } else {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(list.size());
            map.put(val, newSet);
            list.add(val);
        
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        
        int delIdx = map.get(val).iterator().next();
        int lastElement = list.get(list.size() - 1);
        
        if (lastElement == val) {
            delIdx = list.size() - 1;
        } else {
            list.set(delIdx, lastElement);
            map.get(lastElement).remove(list.size() - 1);
            map.get(lastElement).add(delIdx);
        }
        
        list.remove(list.size() - 1);
        map.get(val).remove(delIdx);
        
        if (map.get(val).isEmpty())
            map.remove(val);
        
            
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get( random.nextInt(list.size()) );
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
