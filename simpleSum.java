package Lab4;

public class simpleSum {

    public static void main(String[] args){
        int N = 100000000;
        long sum = 0;
        long timeSum = 0;
        for(int i = 0; i < 10; i++) {

            long start = System.nanoTime();
            for (int k = 1; k <= N; k++) {
                sum += k;
            }
            long elapsed = System.nanoTime() - start;
            timeSum += elapsed;
        }
        long avgElapsed = timeSum / 10;
        System.out.println(N + ", " + sum + ", " + avgElapsed);

    }
}
