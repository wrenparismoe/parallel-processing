package Lab4;

public class threadSum extends Thread {

    public int start, end;
    public long sum;

    public threadSum(int s, int e) {
        this.start = s;
        this.end = e;
        this.sum = 0;
    }

    @Override
    public void run(){
        for (int k = start; k <= end; k++) {
            sum += k;
        }
    }

    public long getSum(){
        return sum;
    }
}
