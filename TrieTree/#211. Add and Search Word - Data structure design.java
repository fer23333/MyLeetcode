
class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEnd;
    public TrieNode(){
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

class WordDictionary {

    /** Initialize your data structure here. */
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0; i< word.length(); i++){
            char c= word.charAt(i);
            if(c == '.'){
                for(char key : cur.children.keySet()){
                    if( search( word.substring(0,i) + key 
                        + word.substring(i+1, word.length()))
                      ){
                        
                        return true;
                    }
                }
                return false;
            }else if(cur.children.containsKey(c)){
                cur = cur.children.get(c);
            }else{
                return false;
            }
        }
        return cur.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
