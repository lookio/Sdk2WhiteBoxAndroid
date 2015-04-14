package com.service.activate;

import com.pages.Serve;
import org.apache.log4j.Logger;

/**
 * Created by asih on 09/03/2015.
 */
public class ServeActivator {

    private static final ServeActivator INSTANCE = new ServeActivator();
    private static final Logger logger = Logger.getLogger(ChatActivator.class);
    private Serve serve = new Serve(true, true);

    private ServeActivator(){
    }

    public static ServeActivator getInstance(){
        return INSTANCE;
    }

    public void feedServeInfo(
            Serve.Satisfection rate, boolean isResolved, boolean isSendTranscript, String email) throws Exception{
        serve.getValidate();
        serve.prepareElements();
        serve.getActivate().feedServeInfo(rate, isResolved, isSendTranscript, email);
    }

}
