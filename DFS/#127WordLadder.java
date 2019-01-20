beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

首先输入wordlist是list 先转化为set 方便使用


       
        if(wordList == null) return 0;
        if(beginWord.equals(endWord)) return 1;
        
        Set<String> dic = new HashSet<>(wordList);
        if(!dic.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        queue.offer(beginWord);
        set.add(beginWord);
        
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (String word : getNext(current, dic)) {
                    if (set.contains(word)) {
                        continue;
                    }
                    if (word.equals(endWord)) {
                        return length;
                    }
                    queue.offer(word);
                    set.add(word);
                }
            }
        }
        return 0;
    }
    
    private List<String> getNext(String current, Set<String> dic) {
        List<String> rel = new ArrayList<String>(); 

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < current.length(); i++) {
                char[] chars = current.toCharArray(); //26个字母只换一个
                chars[i] = c;
                String temp = new String(chars);//生成新的String
                
                if (dic.contains(temp)) {
                     rel.add(temp);
                }
            }
        }
        return rel;
        
    } 
