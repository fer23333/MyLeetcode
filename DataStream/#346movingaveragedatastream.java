// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.Example

// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1 // return 1.00000
// m.next(10) = (1 + 10) / 2 // return 5.50000
// m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
// m.next(5) = (10 + 3 + 5) / 3 // return 6.00000

public class MovingAverage {
    /*
    * @param size: An integer
    */
    Queue<Integer> q;
    private int size;
    private double sum;
    public MovingAverage(int size) {
        // do intialization if necessary
        q = new LinkedList<>();
        this.size = size;
        sum =0;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        if(q.size() < size){
            sum += val;
            q.offer(val);
        }else{
            sum -= q.poll();
            q.offer(val);
            sum += val;
        }
        return sum/q.size();
        
    }
}
