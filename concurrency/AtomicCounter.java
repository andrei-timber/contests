import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicCounter {
    private static final int NUM_THREADS = 10;
    private static final int NUM_COUNTS = 1000000;

    private static volatile int counterVolatile = 0; // intentionally not thread-safe

    public static class AtomicCounterSynchronized {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public synchronized int getCount() {
            return count;
        }
    }

    public static class AtomicCounterAtomicInteger {
        private AtomicInteger count = new AtomicInteger(0);

        public void increment() {
            count.incrementAndGet();
        }

        public int getCount() {
            return count.get();
        }
    }

    public static class AtomicCounterReentrantLock {
        private final ReentrantLock lock = new ReentrantLock();
        private int counter = 0;

        public void increment() {
            lock.lock();
            try {
                counter++;
            } finally {
                lock.unlock();
            }
        }

        public int getCount() {
            lock.lock();
            try {
                return counter;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicCounterSynchronized counterSynchronized = new AtomicCounterSynchronized();
        AtomicCounterAtomicInteger counterAtomicInteger = new AtomicCounterAtomicInteger();
        AtomicCounterReentrantLock counterReentrantLock = new AtomicCounterReentrantLock();
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < NUM_COUNTS; j++) {
                    counterSynchronized.increment();
                    counterAtomicInteger.increment();
                    counterReentrantLock.increment();
                    counterVolatile++;
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }

        System.out.println("counterVolatile - final count: " + counterVolatile);
        System.out.println("AtomicCounterSynchronized - final count: " + counterSynchronized.getCount());
        System.out.println("AtomicCounterAtomicInteger - final count: " + counterAtomicInteger.getCount());
        System.out.println("AtomicCounterReentrantLock - final count: " + counterReentrantLock.getCount());
    }
}