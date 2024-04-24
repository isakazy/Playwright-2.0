package testPacage;

import base.baseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sideTest extends baseTestClass {
    @Test
    public void testNavigate(){
       logInPage = homePage.NavigateToLoginPage();
        String actualTitle = logInPage.getLogInPageTitle();
        Assert.assertEquals(actualTitle, page.title());


    }

}
