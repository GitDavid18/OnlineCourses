package com.codewithmosh.mediator;

public class LoginScreen {
    private TextBox TB_UserName = new TextBox();
    private TextBox TB_Password = new TextBox();
    private Button B_SignUP = new Button();
    private CheckBox CB_Terms = new CheckBox();

    public LoginScreen(){
        B_SignUP.attach(this::clickButton);
        CB_Terms.attach(this::enableButton);
        TB_Password.attach(this::enableButton);
        TB_UserName.attach(this::enableButton);
    }

    public void simulateUser(){
        TB_UserName.setContent("ABC");
        clickButton();
        TB_Password.setContent("123");
        clickButton();
        CB_Terms.setChecked(true);
        clickButton();
    }

    private boolean inputPresent(TextBox box){
        var content = box.getContent();
        return content != null && !content.isEmpty();
    }

    private void enableButton(){
        System.out.println("ISChecked " + CB_Terms.isChecked());
        System.out.println("PW " + TB_Password.getContent());
        System.out.println("user " + TB_UserName.getContent());

        if(CB_Terms.isChecked() == true && inputPresent(TB_Password) && inputPresent(TB_UserName))
            B_SignUP.setEnabled(true);
        else
            B_SignUP.setEnabled(false);
    }

    private void clickButton(){
        System.out.println("Trying to press button");
        if(B_SignUP.isEnabled())
            System.out.println("Successfully signed up");
        else
            System.out.println("Button is disabled");
    }
}
