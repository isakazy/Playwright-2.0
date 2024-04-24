package base;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LogInPage;
import pages.RegisterAccountPage;
import playwrightUtil.playwrightFactory;

import java.util.Properties;

public class baseTestClass {



    playwrightFactory pf;
   protected   Page page;
   protected HomePage homePage;
   protected LogInPage logInPage;
   protected RegisterAccountPage registerAccountPage;
   Properties properties;




    @BeforeTest
    public void SetUp() {
        pf = new playwrightFactory();
        page = pf.InitializeBrowser();
        homePage = new HomePage(page);



    }

    @AfterTest
    public void Close(){
        page.context().browser().close();

    }

}
