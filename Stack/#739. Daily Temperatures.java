//单调栈
public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0){
            return new int[]{};
        }
        int[] res = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i= T.length-1; i>=0; i--){
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
