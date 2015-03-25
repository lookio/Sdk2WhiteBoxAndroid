package appium;

import com.config.base.ConfigItemsRouter;
import com.pages.ChooseChatType;
import com.pages.ChooseCustomerType;
import com.service.activate.ChatActivator;
import com.service.activate.DemoActivator;
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
public class FirstTestDemo extends BaseTest {

    private static final String testDir = "C:\\Users\\asih\\IdeaProjects\\Sdk2WhiteBoxAndroid\\test\\src\\main\\resources\\first_test_demo\\";
    private DemoActivator demo = DemoActivator.getInstance();
    private ChatActivator chat = ChatActivator.getInstance();
    private static final Logger logger = Logger.getLogger(FirstTestDemo.class);


    @Before
    public void setUp() throws Exception {
        super.setUp(AppiumDrivers.ANDROID, ConfigItemsRouter.ConfigType.LECreate, testDir);
    }

    @Test
    public void apiDemo() throws Exception {
        demo.chooseCostumerType(ChooseCustomerType.CustomerType.EXISTING_COSTUMER);
        demo.feedAccountDetails("71807640", "asih@liveperson.com", "Carish74");
        super.service.rotate(ScreenOrientation.LANDSCAPE);
        demo.chooseChatType(ChooseChatType.ChatType.NATIVE);
        demo.findApp("Google");
        demo.startDemo("Google");
        demo.enterChat();
        chat.feedPersonalInfo("Asid", "asdih@liveperson.com", "0544636220", ChooseCustomerType.CustomerType.EXISTING_COSTUMER);
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
