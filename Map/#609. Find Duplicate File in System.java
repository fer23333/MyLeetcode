class Solution {
// Input:
// ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
// Output:  
// [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]

    public List<List<String>> findDuplicate(String[] paths) {
        if(paths == null || paths.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths){
            String[] str = path.split("\\s+");
            String head= str[0];
            for(int i=1; i< str.length; i++){
                String body = str[i];
                int index = body.indexOf('(');
                String tail = body.substring(0,index);
                String pattern = body.substring(index+1, body.length() -1);
                if(!map.containsKey(pattern)){
                    map.put(pattern, new ArrayList<String>());
                }
                map.get(pattern).add(head+ "/" + tail);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key).size() > 1){
                result.add(map.get(key));
            }
        }
        return result;
    }
}
