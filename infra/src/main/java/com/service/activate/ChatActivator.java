package com.service.activate;

import com.pages.ChooseCustomerType;
import com.sun.istack.NotNull;
import com.pages.Chat;
import com.pages.PersonalInfo;
import org.apache.log4j.Logger;

/**
 * Created by asih on 09/03/2015.
 */
public class ChatActivator {

    private static final ChatActivator INSTANCE = new ChatActivator();
    private static final Logger logger = Logger.getLogger(ChatActivator.class);

    private PersonalInfo info = new PersonalInfo(true, true);
    private Chat chatPage = new Chat(true, true);

    private ChatActivator(){

    }

    public static ChatActivator getInstance(){
        return INSTANCE;
    }

    public void feedPersonalInfo(@NotNull String name, @NotNull String email, String phone, ChooseCustomerType.CustomerType type) throws Exception {
        info.getValidate();
        info.prepareElements();
        info.getActivate().feedPersonalInfo(name, email, phone, type);
    }

    public void sendChatMsg(@NotNull String msg) throws Exception {
        chatPage.getValidate();
        chatPage.prepareElements();
        chatPage.getActivate().sendMsg(msg);
    }

    public void ensSession(){
        chatPage.getActivate().ensSession();
    }

}
