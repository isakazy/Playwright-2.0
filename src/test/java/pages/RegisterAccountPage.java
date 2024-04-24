package pages;

import com.microsoft.playwright.Page;

public class RegisterAccountPage {

    Page page;
    public RegisterAccountPage(Page page){
        this.page = page;
    }
    String firstNameInputField = "//input[@id='input-firstname']";
    String lastNameInputField = "//input[@id='input-lastname']";
    String emailInputField = "//input[@id='input-email']";
    String telephoneInputField = "//input[@id='input-telephone']";

    public void fillPersonalDetails(String firstName, String lastName, String email, String phoneNumber ){
        page.fill(firstNameInputField, firstName);
        page.fill(lastNameInputField, lastName);
        page.fill(emailInputField, email);
        page.fill(telephoneInputField, phoneNumber);
    }


    String passwordInputField = "//input[@id='input-password']";
    String confirmPass = "//input[@id='input-confirm']";

    public void cratePassword(String NewPassword, String confirmPassword){
        page.fill(passwordInputField, NewPassword);
        page.fill(confirmPass, confirmPassword);
    }

    String agreeBox = "//input[@name='agree']";
    String continueButton = "//input[@class='btn btn-primary']";

    public AccountCreatedPage ClickSubmit(){
        page.click(agreeBox);
        page.click(continueButton);
        return new AccountCreatedPage(page);

    }






}
