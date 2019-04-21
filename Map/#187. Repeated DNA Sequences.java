public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() < 10){
            return new ArrayList<>();
        }    
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for(int i=0; i<= s.length()- 10; i++){
            String cur = s.substring(i,i+10);
            if(!set.contains(cur)){
               set.add(cur);
            }else{
                result.add(cur);
            }
        }
        List<String> res=  new ArrayList<>();
        res.addAll(result);
        return res;
        
    }
