package pkg;
class Runnablenew implements Runnable {
    public void run() {
        System.out.println("Thread is running");
    }
}
public class Runnablethread {

	public static void main(String[] args) {
		
Runnablenew runnable = new Runnablenew();
        
        
        Thread t= new Thread(runnable);
        
        t.start();
    }
	}


