//使用 linkedhashset
   public int firstUniqueNumber(int[] nums, int number) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        Set<Integer> uniques = new LinkedHashSet<Integer>();
        Set<Integer> dupes = new HashSet<Integer>();
        
        int i = 0;
        for (; i < nums.length; i++) {
            int current = nums[i];
            if (uniques.contains(current)) {
                uniques.remove(current);
                dupes.add(current);
            }
            else {
                if (dupes.contains(current)) {
                    continue;
                }
                uniques.add(current);
            }
            
            if (current == number) {
                break;
            }
        }
        
        if (uniques.size() == 0 || i == nums.length) {
            return -1;
        }
        
        int res = 0;
        Iterator<Integer> itr = uniques.iterator();
        while (itr.hasNext()) {
            res = itr.next();
            break;
        }
        return res;
    }
