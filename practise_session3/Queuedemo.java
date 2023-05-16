package Package3;

import java.util.*;

import java.util.LinkedList;
import java.util.Queue;
public class Queuedemo {
   public static void main(String[] args) {
      Queue<Integer> q = new LinkedList<>();
      q.add(1);
      q.add(2);
      q.add(3);
      q.add(4);
      q.add(5);
      System.out.println("The queue is: " + q);
      int num1 = q.remove();
System.out.println("The element deleted from the head is: " + num1);
System.out.println("The queue after deletion is: " + q);

int size = q.size();
System.out.println("The size of the queue is: " + size);
}
}