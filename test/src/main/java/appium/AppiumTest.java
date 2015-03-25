package appium;


import com.config.base.ConfigItemsRouter;
import com.pages.ChooseChatType;
import com.pages.ChooseCustomerType;
import com.pages.Serve;


import com.service.activate.ChatActivator;
import com.service.activate.DemoActivator;
import com.service.activate.ServeActivator;
import com.service.validate.DemoValidator;
import com.ui.service.drivers.AppiumDrivers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;

/**
 * Created by asih on 16/02/2015.
 */
public class AppiumTest extends BaseTest {

    private static final String testDir = "C:\\Users\\asih\\IdeaProjects\\Sdk2WhiteBoxAndroid\\test\\src\\main\\resources\\test1\\";
    private DemoActivator demo = DemoActivator.getInstance();
    private ChatActivator chat = ChatActivator.getInstance();
    private ServeActivator serve = ServeActivator.getInstance();
    private DemoValidator demoValid = DemoValidator.getInstance();


//    static int pnum =0;

    @Before
    public void setUp() throws Exception {
        super.setUp(AppiumDrivers.ANDROID, ConfigItemsRouter.ConfigType.LECreate, testDir);
    }

    @Test
    public void apiDemo() throws Exception {
        super.service.rotate(ScreenOrientation.LANDSCAPE);
        demo.chooseCostumerType(ChooseCustomerType.CustomerType.POTENTIAL_COSTUMER);
        demo.chooseChatType(ChooseChatType.ChatType.NATIVE);
        demo.findApp("Google");
        demo.startDemo("Google");
        demo.enterChat();
        super.service.rotate(ScreenOrientation.PORTRAIT);
        chat.feedPersonalInfo("Asid", "asdih@liveperson.com", "0544636220", ChooseCustomerType.CustomerType.POTENTIAL_COSTUMER);
        chat.sendChatMsg("Asi is the king");
        chat.ensSession();
        serve.feedServeInfo(Serve.Satisfection.SATISFIED, true, true, "ddd@test.com");
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