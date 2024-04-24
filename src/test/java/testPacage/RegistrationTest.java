package testPacage;

import base.baseTestClass;
import org.testng.annotations.Test;
import pages.RegisterAccountPage;
import playwrightUtil.Config;

public class RegistrationTest  extends baseTestClass {
    @Test
    public void TestRegistration(){
       logInPage = homePage.NavigateToLoginPage();
       registerAccountPage = logInPage.loginNew();
       registerAccountPage.fillPersonalDetails(
               Config.getValue("firstName"),
               Config.getValue("lastName"),
               Config.getValue("email"),
               Config.getValue("phoneNumber"));
       registerAccountPage.cratePassword("Isakazyamanbaev", "Isakazyamanbaev");
       registerAccountPage.ClickSubmit();
        System.out.println("the title is: "+ page.title());
    }


}
