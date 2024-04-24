package testPacage;

import base.baseTestClass;
import constants.ApplicationConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import playwrightUtil.Config;

public class TestHomePage extends baseTestClass {


    @Test
    public void TitleTest() {
        Assert.assertEquals(homePage.getHomeTitle(), ApplicationConstants.LOGIN_PAGE_TITLE);
    }

    @Test
    public void UrlTest(){
        Assert.assertEquals(homePage.getHomeUrl(), Config.getValue("url"));
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


    @Test
    public void testWarning(){
        homePage.NavigateToLoginPage();


    }







}
