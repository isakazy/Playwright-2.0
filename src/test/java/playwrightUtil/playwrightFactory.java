package playwrightUtil;

import com.microsoft.playwright.*;

import java.util.Properties;

public class playwrightFactory {

    Properties properties;
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page InitializeBrowser(){
        String BrowserName = Config.getValue("browser");
        System.out.println("Browser Name is: "+ BrowserName);

        playwright = Playwright.create();

        switch (BrowserName.toLowerCase()){
            case "chromium" :
              browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
              break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
            default:
                System.out.println("Please wright correct Browser Name...........");
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(Config.getValue("url").trim());
        return page;
    }


    }


