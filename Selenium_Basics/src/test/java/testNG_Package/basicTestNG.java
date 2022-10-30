package testNG_Package;

import org.testng.annotations.*;

public class basicTestNG {
    @Test
    public void sample(){
        System.out.println("Test1 Method");
    }
    @BeforeMethod
    public void sample1(){
        System.out.println("Before Method");
    }
    @Test
    public void sample2(){
        System.out.println("Test2 Method");
    }
    @AfterMethod
    public void sample3(){
        System.out.println("After Method");
    }
    @BeforeClass
    public void sample4(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void sample5(){
        System.out.println("After Class");
    }
    @BeforeTest
    public void sample6(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void sample7(){
        System.out.println("After Test");
    }
    @BeforeSuite
    public void sample8(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void sample9(){
        System.out.println("After Suite");
    }
}
