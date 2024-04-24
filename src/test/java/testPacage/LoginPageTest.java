package testPacage;

import base.baseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import playwrightUtil.Config;

public class LoginPageTest extends baseTestClass {

    @Test
    public void TestLogIn(){
        logInPage = homePage.NavigateToLoginPage();
        String actualTitle = logInPage.getLogInPageTitle();
        Assert.assertEquals(actualTitle, logInPage.getLogInPageTitle());
        logInPage.login("isakazy", "amanbaev");
        Assert.assertTrue(logInPage.WarningMassageIsVisible());
    }

    @Test
    public void TestLoginV2(){
        logInPage = homePage.NavigateToLoginPage();
        String actualTitle = page.title();
        Assert.assertEquals(actualTitle, page.title());
        logInPage.login(Config.getValue("email"), Config.getValue("password"));
        String actualTitleLogIn = page.title();
        Assert.assertEquals(actualTitleLogIn, Config.getValue("expectedTitle"));
    }

}
