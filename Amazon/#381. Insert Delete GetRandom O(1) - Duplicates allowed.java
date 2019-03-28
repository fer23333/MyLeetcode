class RandomizedCollection {

    /** Initialize your data structure here. */
    Map<Integer, Set<Integer>> map;
    List<Integer> list; 
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            list.add(val);
            map.put(val, new HashSet<>());
            map.get(val).add(list.size()-1);
            return true;
        }
        list.add(val);
        map.get(val).add(list.size() -1);
        return false;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        Set<Integer> indexSet = map.get(val);
        Iterator<Integer> it = indexSet.iterator();
        int curIndex = it.next();
        indexSet.remove(curIndex);
        if(curIndex < list.size()-1){
            int lastElement = list.get(list.size()-1);
            list.set(curIndex, lastElement);
            Set<Integer> lastSet = map.get(lastElement);
            lastSet.remove(list.size()-1);
            lastSet.add(curIndex);
        }
        
        if(indexSet.size() == 0){
            map.remove(val);
        }
        
        
        list.remove(list.size()-1);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
