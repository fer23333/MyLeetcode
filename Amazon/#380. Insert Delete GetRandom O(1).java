//import java.util.*;
class RandomizedSet {

    /** Initialize your data structure here. */
    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int curIndex = map.get(val);
        if(curIndex < list.size() -1){
            int lastElement = list.get(list.size() -1);
            list.set(curIndex, lastElement);
            map.put(lastElement, curIndex);
        }
        list.remove(list.size() -1);
        map.remove(val);                       
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        // int value between 0 (inclusive) and the specified value (exclusive)
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        System.out.println(index);
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
