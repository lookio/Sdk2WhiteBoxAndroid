
package appium;


import com.config.base.ConfigItemsRouter;
import com.ui.service.AppiumService;
import com.ui.service.drivers.AppiumDrivers;
import com.ui.service.drivers.SeleniumDrivers;
import org.apache.log4j.Logger;


public class BaseTest  {

    private static final Logger logger = Logger.getLogger(BaseTest.class);
    private static final String LOG4J_PROP_FILE_PATH_KEY_VALUE = "Log4jPropFilePath";
    protected AppiumService service = AppiumService.getInstance();


    public void setUp(AppiumDrivers driver, ConfigItemsRouter.ConfigType confType, String testPath) throws Exception {
//        service.setDriver(AppiumDrivers.ANDROID, testPath);
        if(confType != null) {
            ConfigItemsRouter.getInstance().routeAction(confType, testPath);
        }
    }

    protected void tearDown(DriverType driver) throws Exception {
        if(driver == DriverType.SELENIUM){
            SeleniumDrivers.close();
        }else if(driver == DriverType.APPIUM){
            AppiumDrivers.close();
        }
    }

    public static void after(DriverType driver) throws Exception {
        if(driver == DriverType.SELENIUM){
            SeleniumDrivers.close();
        }else if(driver == DriverType.APPIUM){
            AppiumDrivers.close();
        }
    }

    public enum DriverType{
        SELENIUM, APPIUM;
    }



}
