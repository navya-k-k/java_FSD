package pkg;


public class Demosleep {

	public static void main(String[] args) {
		
		final Object lock = new Object();

        Thread sleepThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("SleepThread: I'm going to sleep for 3 seconds.");
                    Thread.sleep(3000); // Sleep for 3 seconds
                    System.out.println("SleepThread: I woke up after sleeping for 3 seconds.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread waitThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("WaitThread: I'm waiting for a notification.");
                    lock.wait(); // Wait for notification
                    System.out.println("WaitThread: I received a notification and woke up.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        sleepThread.start(); // Start the sleep thread

        try {
            Thread.sleep(1000); // Sleep for 1 second to ensure sleepThread starts first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        waitThread.start(); // Start the wait thread

        try {
            sleepThread.join(); // Wait for sleepThread to finish
            waitThread.join(); // Wait for waitThread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main: Program execution completed.");
    }

	}


