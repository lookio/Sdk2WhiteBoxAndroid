package appium;

import com.config.base.ConfigItemsRouter;
import com.pages.demo_app.ChooseChatType;
import com.pages.demo_app.ChooseCustomerType;
import com.service.activate.demo_app.DemoActivator;
import com.service.activate.echo_test.ChatActivator;
import com.service.activate.echo_test.SettingsActivator;
import com.ui.service.drivers.AppiumDrivers;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;

/**
 * Created by asih on 18/03/2015.
 */
public class EcoFirstTestDemo extends BaseTest {

    private static final String testDir = "./src/main/resources/first_test_demo_eco/";
    private SettingsActivator settingsActivator = SettingsActivator.getInstance();
    private ChatActivator chatActivator = ChatActivator.getInstance();
    private static final Logger logger = Logger.getLogger(EcoFirstTestDemo.class);


    @Before
    public void setUp() throws Exception {
        super.setUp(
                AppiumDrivers.ANDROID,
                ConfigItemsRouter.ConfigType.LECreate, testDir);
    }

    @Test
    public void apiDemo() throws Exception {
        settingsActivator.connectToAccount("89961346", "asih@liveperson.com", "Carish74"); // no skill mobile
        // verify no call in agent service
        settingsActivator.connectToAccount("89961346", "asihiz@yahoo.com", "Carish74"); // with skill mobile
        // verify call in agent service
        chatActivator.sendChatMsg("Asi is the king");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown(DriverType.APPIUM);
    }

    @AfterClass
    public static void after() throws Exception {
//        BaseTest.after(DriverType.APPIUM);
    }
}
