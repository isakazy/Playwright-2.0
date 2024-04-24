package pages;

import com.microsoft.playwright.Page;

public class LogInPage {



    private Page page;

    private final String userNameInputField = "//input[@id='input-email']";
    private final String passwordInputField = "//input[@id='input-password']";
    private final String loginButton = "//input[@class='btn btn-primary']";
    private final String warningMassage = "//div[.=' Warning: No match for E-Mail Address and/or Password.']";
    private final String loginAsNew = "//a[.='Continue']";

    public LogInPage(Page page){
        this.page = page;
    }

    public  String getLogInPageTitle(){
        return page.title();
    }

    public boolean WarningMassageIsVisible(){
       return page.isVisible(warningMassage);

    }

    public void login(String username, String password ){
        System.out.println("your credentials are: "+ username + " password: "+ password);
        page.fill(userNameInputField, username);
        page.fill(passwordInputField, password);
        page.click(loginButton);
    }

    public RegisterAccountPage loginNew(){
        page.click(loginAsNew);
        return new RegisterAccountPage(page);
    }


}
