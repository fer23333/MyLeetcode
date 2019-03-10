
    //my solution
    
        public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map=  new HashMap<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String pattern = String.valueOf(ch);
            if(!map.containsKey(pattern)){
               map.put(pattern, new ArrayList<>());    
            }
             map.get(key).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for(String key: map.keySet()){
            List<String> temp = new ArrayList<>();
            temp.addAll(map.get(key));
            result.add(temp);
        }
        return result;
        //return new ArrayList<List<String>>(map.values());
    }
