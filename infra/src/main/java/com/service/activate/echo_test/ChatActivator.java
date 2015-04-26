package com.service.activate.echo_test;

import com.pages.echo_test.Chat;
import org.apache.log4j.Logger;

/**
 * Created by asih on 09/03/2015.
 */
public class ChatActivator {

    private static final ChatActivator INSTANCE = new ChatActivator();
    private static final Logger logger = Logger.getLogger(ChatActivator.class);

    private Chat chatPage = new Chat(true, true);

    private ChatActivator(){

    }

    public static ChatActivator getInstance(){
        return INSTANCE;
    }

    public void sendChatMsg(String msg) throws Exception {
        chatPage.validateInPage();
        chatPage.prepareElements();
        chatPage.getActivate().sendMsg(msg);
    }

    public void ensSession(){
        chatPage.getActivate().ensSession();
    }

}
