//考察string排序的一种方法
//然后要去掉所有开头为零即(0,0,0)
 public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        List<String> list = new ArrayList<>();
        for(int i : nums){
            list.add(String.valueOf(i));
        }
        Collections.sort(list, (a,b) -> (b+a).compareTo(a+b));
        StringBuilder res = new StringBuilder();
        for(String s : list){
            res.append(s);
        }
        if(res.charAt(0) == '0'){
            return "0";
        }
        return res.toString();
        
    }
