package pages;

import com.microsoft.playwright.Page;

public class HomePage {

   private final Page page;

    // 2. Page constructor
    public HomePage(Page page){
        this.page = page;
    }


    //3.  page actions
    public String getHomeTitle(){
        String title = page.title();
        System.out.println("page title is: "+ title);
        return title;
    }
    public String getHomeUrl(){
        String url = page.url();
        System.out.println("page url is: " + url);
        return url;
    }
    public void doSearch(String productName){
        // 1. String collector - OR
        String searchInput = "//input[@name='search']";
        page.fill(searchInput, productName);
        String searchButton = "//button[@class='btn btn-default btn-lg']";
        page.click(searchButton);
        String macbook = "//div[@id='content']/h1";
        String header =  page.textContent(macbook);
        System.out.println("the search header is: "+ header);
    }

}
