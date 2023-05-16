package pkg;

class Threadprog extends Thread {
 public void run() {
     System.out.println("Thread is running");
 }




 public static void main(String[] args) {
     
     Threadprog t = new Threadprog();
     
     
     t.start();
 }
}
