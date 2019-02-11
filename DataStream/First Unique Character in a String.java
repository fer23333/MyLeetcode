O(n) 使用数组字典存储

   public int firstUniqChar(String s) {
        if(s == null){
            return -1;
        }
        int[] record = new int[256];
        for(int i = 0; i < s.length(); i++){
            record[s.charAt(i)]++;
        }
        for(int i = 0; i < s.length(); i++){
            if(record[s.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
    
    空间为O(1)
        public char firstUniqChar(String str) {
        // Write your code here
        int left = 0, right = 0;
        while (left < str.length()) {
            while (right < str.length() && str.charAt(left) != str.charAt(right) || left == right) {
                right++;
            }
            if (right == str.length()) {
                return str.charAt(left);
            }
            left++;
            right = 0;
        }
        return '0';
    }
    
    data stream
    
        class ListCharNode {
        public char val;
        public ListCharNode next;
        public ListCharNode(char val) {
            this.val = val;
            this.next = null;
        }
    }
    
    class DataStream {
        private Map<Character, ListCharNode> charToPrev;
        private Set<Character> dupChars;
        private ListCharNode dummy, tail;
        
        public DataStream() {
            charToPrev = new HashMap<>();
            dupChars = new HashSet<>();
            dummy = new ListCharNode('.');
            tail = dummy;
        }
        
        public void add(char c) {
            if (dupChars.contains(c)) {
                return;
            }
            
            if (!charToPrev.containsKey(c)) {
                ListCharNode node = new ListCharNode(c);
                charToPrev.put(c, tail);
                tail.next = node;
                tail = node;
                return;
            }
            
            // delete the existing node
            ListCharNode prev = charToPrev.get(c);
            prev.next = prev.next.next;
            if (prev.next == null) {
                // tail node removed
                tail = prev;
            } else {
                charToPrev.put(prev.next.val, prev);
            }
            
            charToPrev.remove(c);
            dupChars.add(c);
        }
        
        public char firstUniqueChar() {
            return dummy.next.val;
        }
    }
    
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        DataStream ds = new DataStream();
        for (int i = 0; i < str.length(); i++) {
            ds.add(str.charAt(i));
        }
        return ds.firstUniqueChar();
    }
