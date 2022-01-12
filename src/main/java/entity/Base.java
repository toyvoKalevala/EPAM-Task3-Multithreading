package entity;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Base {

    private static Semaphore semaphore = new Semaphore(2, true);
    private static Lock lock = new ReentrantLock();

    private static Base instance;

    public static Base getInstance() {
        Base localInstance = instance;
        if (localInstance == null) {
            lock.lock();
            localInstance = instance;
            if (localInstance == null) {
                instance = localInstance = new Base();
            }
            lock.unlock();
        }
        return localInstance;
    }

    public void process(Truck truck) {
        try {
            semaphore.acquire();
            lock.lock();
            if (truck.getLoading()) {
                truck.setLoading(false);
            } else {
                truck.setLoading(true);
            }
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            semaphore.release();
            lock.unlock();
        }
    }
}
