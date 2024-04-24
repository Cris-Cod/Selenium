package testNGTutorial.test;

import org.testng.annotations.Test;

public class Test3 {

    @Test
    public void Weblogin(){
        System.out.println("Weblogincar");
    }

    @Test
    public void MobileLoginLoan(){
        System.out.println("Mobilelogincar");
    }

    @Test
    public void LoginAPILoan(){
        System.out.println("LoginAPIcar");
    }

    @Test
    public void MobileLoginLoanSingIN(){
        System.out.println("MobilelogincarSingIN");
    }

    @Test(groups ={"Smoke"})
    public void MobileLoginLoanSingOUT(){
        System.out.println("MobilelogincarSingOUT");
    }
}
