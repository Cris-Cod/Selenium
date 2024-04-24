package testNGTutorial.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {

    @Test(groups ={"Smoke"})
    public void good(){
        System.out.println("good");
    }

    @BeforeTest
    public void Prerequisite(){
        System.out.println("Execute first");
    }
}
