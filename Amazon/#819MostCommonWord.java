priorityqueue 构建时间复杂度为O(n)不是O(nlogn) 因为有一半不需要logn操作
每次offer和poll时由于堆得heapify操作 是O(logn)

public String mostCommonWord(String paragraph, String[] banned) {
        String s = paragraph.replaceAll("[^\\w+]", " ").toLowerCase();
        //    ^[//w+]表示 [^A-za-z0-9] 的word 并且包含多个word的情况
        String[] str = s.split("\\s+");
        //   [//s+] 如果有多个空格也合并为一个空格并split 不然空格也会被认为是频率 
        Map<String, Integer> map = new HashMap<>();
        //map store string and frequency
        Set<String> set = new HashSet<>();
        
        for(String ban : banned){
            set.add(ban);
        }
        for(String n:str){
            if(!set.contains(n)){
                map.put(n, map.getOrDefault(n, 0) + 1);
            }

        }
        //priority queue maxHep
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b) -> b.getValue() - a.getValue()
        );
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        return pq.poll().getKey();
    }
    
    也可以不用priorityqueue
    
        String res = null;
        for(String word : map.keySet())
            if(res == null || map.get(word) > map.get(res))
                res = word;
        return res;
