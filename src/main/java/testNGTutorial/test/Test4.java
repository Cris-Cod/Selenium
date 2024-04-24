package testNGTutorial.test;

import org.testng.annotations.Test;

public class Test4 {

    @Test
    public void WebloginHome(){
        System.out.println("Webloginhome");
    }

    @Test(groups ={"Smoke"})
    public void MobileLoginHomeLoan(){
        System.out.println("Mobileloginhome");
    }

    @Test
    public void LoginAPIHomeLoan(){
        System.out.println("LoginAPIHome");
    }
}
