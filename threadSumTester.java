package Lab4;
import java.util.ArrayList;
public class threadSumTester {

    static final int R = 8;

    public static void main(String[] args){
        int N = 100000000;
        long sum = 0;
        long timeSum = 0;
        for(int j = 0; j < 10; j++) {
            ArrayList<threadSum> tArrayList = new ArrayList<threadSum>();
            int r = N / R;
            int e = r;
            int s = 1;
            long start = System.nanoTime();
            for (int i = 0; i < R; i++) {
                if (i == (R - 1)) {
                    e = 100000000;
                }
                threadSum t = new threadSum(s, e);
                t.setName("Thread" + (i + 1));
                t.start();
                tArrayList.add(t);
                s += r;
                e += r;
            }
            for (int i = 0; i < R; i++) {
                threadSum twr = tArrayList.get(i);
                while (twr.getState() != Thread.State.TERMINATED);
                sum += twr.getSum();
            }
            long elapsed = System.nanoTime() - start;
            timeSum += elapsed;
        }
        long avgTime = timeSum / 10;
        System.out.println(N + "   " + sum + "   " + avgTime);

    }

}
