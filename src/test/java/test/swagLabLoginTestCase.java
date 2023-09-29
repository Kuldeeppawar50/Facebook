package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pojo.LaunchBrowser;
import pom.swagLabLogin;
import utility.Reports;

public class swagLabLoginTestCase extends Basic {
    ExtentReports extentReports;
    ExtentTest extentTest;
    @BeforeClass
    public void addReports()
    {
        extentReports= Reports.configureReports();
    }

    @BeforeMethod
    public void browser()
    {
        driver=LaunchBrowser.openBrowser("https://www.saucedemo.com/") ;
    }


@Test
    public void loginWithValidCredentials()
    {
        extentTest=extentReports.createTest("loginWithValidCredentials");

        swagLabLogin obj1 = new swagLabLogin(driver);
        obj1.userName("standard_user");
        obj1.passWord("secret_sauce");
        obj1.Login();
    }
@Test
    public void loginWithValidUserNameAndInvalidPassword()
    {
        extentTest=extentReports.createTest("loginWithValidUserNameAndInvalidPassword");
        swagLabLogin obj2 = new swagLabLogin(driver);
        obj2.userName("standard_user");
        obj2.passWord("1234");
        obj2.Login();

    }
    @Test
    public void loginWithInvalidUserNameAndValidPassword()
    {
        extentTest=extentReports.createTest("loginWithInvalidUserNameAndValidPassword");

        swagLabLogin obj3 = new swagLabLogin(driver);
        obj3.userName("abcd");
        obj3.passWord("secret_sauce");
        obj3.Login();
    }

    @AfterMethod
    public void closeBrowser(ITestResult result)
    {
        if(result.getStatus()==result.SUCCESS)
        {
            extentTest.log(Status.PASS,result.getName());
        }
        else if(result.getStatus()==result.FAILURE)
        {
            extentTest.log(Status.FAIL,result.getName());
        }
        else if(result.getStatus()==result.SKIP)
        {
            extentTest.log(Status.SKIP,result.getName());
        }

        driver.close();
    }

    @AfterClass
    public void flushData()
    {
        extentReports.flush();

    }

}



//    public static void main(String[] args) {
//        swagLabLoginTestCase obj4 = new swagLabLoginTestCase();
//        obj4.loginWithValidCredentials();
//        obj4.loginWithValidUserNameAndInvalidPassword();
//
//
//
//    }


