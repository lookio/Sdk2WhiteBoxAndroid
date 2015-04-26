package com.service.activate.echo_test;

import com.pages.demo_app.Chat;
import com.pages.demo_app.ChooseCustomerType;
import com.pages.demo_app.PersonalInfo;
import com.pages.echo_test.Menu;
import com.pages.echo_test.Settings;
import org.apache.log4j.Logger;

/**
 * Created by asih on 09/03/2015.
 */
public class SettingsActivator {

    private static final SettingsActivator INSTANCE = new SettingsActivator();
    private static final Logger logger = Logger.getLogger(SettingsActivator.class);

    private Menu menu = new Menu(true, true);
    private Settings settings = new Settings(true, true);

    private SettingsActivator(){

    }

    public static SettingsActivator getInstance(){
        return INSTANCE;
    }

    public void connectToAccount(String accountId, String userName, String password) throws Exception {
        menu.validateInPage();
        menu.prepareElements();
        menu.getActivate().enterMenuSettings();
        feedAccountInfo(accountId, userName, password);
    }

    public void feedAccountInfo(String accountId, String userName, String password) throws Exception {
        settings.validateInPage();
        settings.prepareElements();
        settings.getActivate().feedAccountDetails(accountId, userName, password);
    }


}
