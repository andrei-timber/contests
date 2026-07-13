public class Race {
    private static final int NUM_THREADS = 10;
    private static final int NUM_COUNTS = 1000000;

    private static int counter = 0; // intentionally not thread-safe     

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadIndex = i;
            threads[threadIndex] = new Thread(() -> {
                for (int j = 0; j < NUM_COUNTS; j++) {
                    counter++;
                    // System.out.println(threads[threadIndex].getName() + " - Counter: " + counter);
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }
        System.out.println("Counter: " + counter);
    }
}