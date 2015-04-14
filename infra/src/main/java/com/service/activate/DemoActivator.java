package com.service.activate;

import com.pages.*;
import com.service.validate.DemoValidator;
import org.apache.log4j.Logger;

/**
 * Created by asih on 08/03/2015.
 */
public class DemoActivator {

    private static final DemoActivator INSTANCE = new DemoActivator();
    private static final Logger logger = Logger.getLogger(DemoActivator.class);

    private ChooseCustomerType costumerType = new ChooseCustomerType(true, true);
    private AccountLogin accountLogin = new AccountLogin(true, true);
    private ChooseChatType choose = new ChooseChatType(true, true);
    private NativeAppSearch appSearch = new NativeAppSearch(true, true);
    private ChooseApp chooseApp = new ChooseApp(true, true);
    private DemoPage demo = new DemoPage(true, true);
    private Engagement engage = new Engagement(true, true);
    private DemoValidator demoValid = DemoValidator.getInstance();


    private DemoActivator(){
    }

    public static DemoActivator getInstance(){
        return INSTANCE;
    }

    public void chooseCostumerType(ChooseCustomerType.CustomerType type) throws Exception{
        costumerType.getValidate();
        costumerType.prepareElements();
        costumerType.getActivate().chooseCostumerType(type);
    }

    public void feedAccountDetails(String _accountId, String _userName, String _password) throws Exception{
        accountLogin.getValidate();
        accountLogin.prepareElements();
        accountLogin.getActivate().feedAccountDetails(_accountId, _userName, _password);
    }

    public void chooseChatType(ChooseChatType.ChatType type) throws Exception{
        choose.getValidate();
        choose.prepareElements();
        choose.getActivate().chooseChatType(type);
    }

    public void findApp(String app) throws Exception{
        appSearch.getValidate();
        appSearch.prepareElements();
        appSearch.getActivate().feedAppName(app);
        appSearch.getActivate().findApp();
    }

    public void startDemo(String app) throws Exception{
        chooseApp(app);
        enterDemo();
    }

    public void chooseApp(String app) throws Exception{
        chooseApp.getValidate();
        chooseApp.prepareElements();
        chooseApp.getActivate().chooseApp(app);;
    }

    public void enterDemo() throws Exception{
        demo.getValidate();
        demo.prepareElements();
        demo.getActivate().startDemo();
    }

    public void enterChat() throws Exception{
        engage.getValidate();
        engage.prepareElements();
        engage.getActivate().enterChat();
    }

}
