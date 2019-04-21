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

1. Imagine you are given a real file system, how will you search files? DFS or BFS ?
In general, BFS will use more memory then DFS. However BFS can take advantage of the locality of files in inside directories, and therefore will probably be faster

2. If the file content is very large (GB level), how will you modify your solution?
In a real life solution we will not hash the entire file content, since it's not practical. Instead we will first map all the files according to size. Files with different sizes are guaranteed to be different. We will than hash a small part of the files with equal sizes (using MD5 for example). Only if the md5 is the same, we will compare the files byte by byte

3. If you can only read the file by 1kb each time, how will you modify your solution?
This won't change the solution. We can create the hash from the 1kb chunks, and then read the entire file if a full byte by byte comparison is required.

What is the time complexity of your modified solution? What is the most time consuming part and memory consuming part of it? How to optimize?
Time complexity is O(n^2 * k) since in worse case we might need to compare every file to all others. k is the file size

How to make sure the duplicated files you find are not false positive?
We will use several filters to compare: File size, Hash and byte by byte comparisons.
