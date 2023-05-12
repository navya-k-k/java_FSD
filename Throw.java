package pkg;

/*class Throw
{
  static void avg()
  {
    try
    {
      throw new ArithmeticException("demo");
    }
    catch(ArithmeticException e)
    {
      System.out.println("Exception");
    }
 }

 public static void main(String args[])
 {
    avg();
 }
}

class Throw
{
  static void check() throws ArithmeticException
  {  
    System.out.println("Inside check function");
    throw new ArithmeticException("demo");
  }

  public static void main(String args[])
  {
    try
    {
      check();
    }
    catch(ArithmeticException e)
    {
      System.out.println("caught" + e);
    }
  }
}


class Throw {
    public static void main(String[] args)
    {
        try {
            System.out.println("inside try block");
            
            // Not throw any exception
            System.out.println(34 / 2);
        }
        
        // Not execute in this case
        catch (ArithmeticException e) {
            
            System.out.println("Arithmetic Exception");
            
        }
        // Always execute
        finally {
            
            System.out.println(
                "finally : i execute always.");
            
        }
    }
}*/

class MyException extends Exception {
    public MyException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}
 
// A Class that uses above MyException
public class Throw {
    // Driver Program
    public static void main(String args[])
    {
        try {
            // Throw an object of user defined exception
            throw new MyException("GeeksGeeks");
        }
        catch (MyException ex) {
            System.out.println("Caught");
 
            // Print the message from MyException object
            System.out.println(ex.getMessage());
        }
    }
}