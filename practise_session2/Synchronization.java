package pkg;

public class Synchronization {
	private int count = 0;
	public static void main(String[] args) {
		
		    

		    
		        Synchronization example = new Synchronization();
		        example.startThreads();
		    }

		    private void startThreads() {
		        Thread thread1 = new Thread(() -> {
		            for (int i = 0; i < 10000; i++) {
		                increment();
		            }
		        });

		        Thread thread2 = new Thread(() -> {
		            for (int i = 0; i < 10000; i++) {
		                increment();
		            }
		        });

		        thread1.start();
		        thread2.start();

		        try {
		            thread1.join();
		            thread2.join();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }

		        System.out.println("Count: " + count);
		    }

		    private synchronized void increment() {
		        count++;
		    }
		


	}


