package testPacage;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import sauceDemo.playwrightFactory;

public class TestHomePage {

    playwrightFactory pf;
    Page page;
    HomePage homePage;



    @BeforeTest
    public void SetUp() {
        pf = new playwrightFactory();
        page = pf.InitializeBrowser("chromium");
        homePage = new HomePage(page);

    }



    @Test
    public void TitleTest() {
        Assert.assertEquals(homePage.getHomeTitle(), "Your Store");
    }

    @Test
    public void UrlTest(){
        Assert.assertEquals(homePage.getHomeUrl(), "https://naveenautomationlabs.com/opencart/");
    }

    @DataProvider
    public Object [][] getProduct(){
        return new  Object [][]{
                {"Samsung"},
                {"Nokia"},
                {"Iphone"},
                {"Ipad"}
        };

    }


    @Test(dataProvider = "getProduct")
    public void SearchTest(String productName) {
        homePage.doSearch(productName);
        String actualHeader = homePage.getHomeTitle();
        Assert.assertEquals(actualHeader, "Search - "+productName);
        page.goBack();
    }





    @AfterTest
    public void Close(){
        page.context().browser().close();

    }


}
