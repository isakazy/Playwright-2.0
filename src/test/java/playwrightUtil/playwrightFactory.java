package playwrightUtil;

import com.microsoft.playwright.*;

import javax.swing.plaf.TableHeaderUI;
import java.util.Properties;

public class playwrightFactory {

    Properties properties;
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    private static final ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static final ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static Playwright getPlaywright(){
        return tlPlaywright.get();
    }

    public static Browser getBrowser(){
        return tlBrowser.get();
    }

    public static BrowserContext getBrowserContext(){
        return tlBrowserContext.get();
    }

    public static Page getPage(){
        return tlPage.get();
    }



    public Page InitializeBrowser(){
        String BrowserName = Config.getValue("browser");
        System.out.println("Browser Name is: "+ BrowserName);

       // playwright = Playwright.create();
        tlPlaywright.set(Playwright.create());

        switch (BrowserName.toLowerCase()){
            case "chromium" :
              //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
              break;
            case "firefox":
                //browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "webkit":
                //browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "chrome":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
            default:
                System.out.println("Please wright correct Browser Name...........");
                break;
        }

        tlBrowserContext.set(getBrowser().newContext());
        tlPage.set(getBrowserContext().newPage());
        getPage().navigate(Config.getValue("url").trim());
        return  getPage();


//        browserContext = browser.newContext();
//        page = browserContext.newPage();
//        page.navigate(Config.getValue("url").trim());
//        return page;
    }


    }


