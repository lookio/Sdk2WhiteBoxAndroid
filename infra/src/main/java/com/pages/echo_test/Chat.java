package com.pages.echo_test;

import com.ui.page.AppiumBasePage;
import com.ui.page.base.NotInPageException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by asih on 08/03/2015.
 */
public class Chat extends AppiumBasePage {

    private final By MSG = By.id("");
    private final By SEND = By.id("");
    private final By END_SESSION = By.id("");
    private final By ACCEPT_END = By.id("");

    private Chat.Activate activate = this.new Activate();
    private Chat.Validate validate = this.new Validate();

    private WebElement msg;
    private WebElement send;
    private WebElement endSession;
    private WebElement acceptEnd;

    public Chat(boolean shouldValidateOnPage, boolean shouldFailTestOnLocation) {
        super(shouldValidateOnPage, shouldFailTestOnLocation);
    }

    @Override
    public void prepareElements() {
        msg = service.findElement(MSG, className + "=msg");
        send = service.findElement(SEND, className + "=send");
        endSession = service.findElement(END_SESSION, className + "=endSession");
        acceptEnd = service.findElement(ACCEPT_END, className + "=acceptEnd");
    }

    public class Activate {

        public void sendMsg(String _msg) {
            msg.sendKeys(_msg);
            send.click();
        }

        public void ensSession() {
            service.scroll("End Session");
            endSession.click();
            acceptEnd.click();
        }
    }

    public class Validate {


    }

    @Override
    public Validate getValidate() {
        return validate;
    }

    @Override
    public Activate getActivate() {
        return activate;
    }

    String unique = "Send a message";
    @Override
    public String getPageUniqueIdentifier() throws NotInPageException {
        return unique;
    }
}
