package testNGTutorial.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test1 {

   @AfterTest
   public void lastExecution(){
       System.out.println("I will execute last");
   }
    @Test
    public void Demo(){
        System.out.println("Hello");
    }

    public void SecondTest(){
        System.out.println("bye");
    }
}
