package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.LaunchBrowser;
@Listeners(test.Listeners.class)

public class swagLabLogin extends Basic {

   @BeforeMethod
    public void browser(){
       driver = LaunchBrowser.openBrowser("https://www.saucedemo.com/");
   }
   @Test
    public void verifySwagLabLogin(){
       SoftAssert softAssert = new SoftAssert();
      pom.swagLabLogin obj2 = new pom.swagLabLogin(driver);
      softAssert.assertTrue(obj2.swagLabLogo());
//       System.out.println(obj2.swagLabLogo());
       obj2.userName("standard_user");
       obj2.passWord("secret_sauce123");
       obj2.Login();
       String currentUrl = driver.getCurrentUrl();
       Assert.assertEquals(currentUrl,"https://www.saucedemo.com/inventory.html");
       System.out.println("post assertion");
       softAssert.assertAll();
   }
}
