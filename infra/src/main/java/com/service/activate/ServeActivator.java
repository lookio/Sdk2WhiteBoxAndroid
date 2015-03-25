package com.service.activate;

import com.sun.istack.NotNull;
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
            @NotNull Serve.Satisfection rate, @NotNull boolean isResolved, @NotNull boolean isSendTranscript, @NotNull String email) throws Exception{
        serve.getValidate();
        serve.prepareElements();
        serve.getActivate().feedServeInfo(rate, isResolved, isSendTranscript, email);
    }

}
