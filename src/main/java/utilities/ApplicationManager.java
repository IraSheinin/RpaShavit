package utilities;
import java.io.IOException;
import java.util.Map;


public class ApplicationManager {
    private static ApplicationManager appManager;
    private static String password;
    private static String userName;
    private static String testName;
    private static String exeToStart;
    private static String excelFileName;
    private static String applicationType;
    private static String excelDataPath;
    private ApplicationProcessHelper startProcessHelper;
    private static int numOfColumnsInExcel;
    private static ExcelDataHelper excelDataHelper;
    private static SendEmailHelper sendEmailHelper;
    public static boolean mainLoopCompleted;
    public static boolean insideLoopCompleted;
    static PropertyManager propertyManagerTest;
    static PropertyManager propertyManagerDefault;

    public static synchronized ApplicationManager getInstance() {
        if (appManager ==null) {
            appManager = new ApplicationManager();
        }
        mainLoopCompleted = false;
        insideLoopCompleted = true;
        return appManager;
    }
    public static void loadDataFromConfigFile(){
        propertyManagerDefault = new PropertyManager("./configuration/DataConfig.properties");
        propertyManagerTest = new PropertyManager("./robots/" + ApplicationManager.getTestName() + "/TestConfig.properties");

        exeToStart = propertyManagerDefault.getConfigData("ExeToStart");
        Log.info("AppManager: ExeToStart "+exeToStart);
        userName = propertyManagerDefault.getConfigData("UserName");
        Log.info("AppManager: UserName "+userName);
        password = propertyManagerDefault.getConfigData("Password");
        Log.info("AppManager: Password "+password);
        excelFileName = propertyManagerTest.getConfigData("ExcelFileName");
        applicationType = propertyManagerTest.getConfigData("ApplicationType");
        numOfColumnsInExcel = Integer.parseInt(propertyManagerTest.getConfigData("NumOfColumnsInExcel"));

        Log.info("AppManager: columns in Excel "+numOfColumnsInExcel);
    }

 //   public static void setMainLoopCompleted(boolean mainLoopCompleted) {
 //       mainLoopCompleted = mainLoopCompleted;
  //  }



    public static String getApplicationType() {
        return applicationType;
    }

    public static int getNumOfColumnsInExcel() {
        return numOfColumnsInExcel;
    }
    public static boolean isMainLoopCompleted() {
        return mainLoopCompleted;
    }


    public  static boolean isInsideLoopCompleted() {
        return insideLoopCompleted;
    }

    public void dismissApp(String exeToKill){
        startProcessHelper.dismiss(exeToKill);
    }

    public ApplicationProcessHelper invokeApplication()  {
        if (startProcessHelper==null){
            startProcessHelper = new ApplicationProcessHelper(appManager);
        }
        return startProcessHelper;
    }

    public static void taskKill(String exeToKill){
        try {
            Process process = Runtime.getRuntime().exec("TASKKILL /F /IM "+ exeToKill + " /T");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getComputerName() {
        Map<String, String> env = System.getenv();
        if (env.containsKey("COMPUTERNAME"))
            return env.get("COMPUTERNAME");
        else if (env.containsKey("HOSTNAME"))
            return env.get("HOSTNAME");
        else
            return "Unknown Computer";
    }

    public static ExcelDataHelper getExcelDataHelper() {
        if (excelDataHelper==null) {
            excelDataHelper = new ExcelDataHelper(getExcelDataPath());
        }
        return excelDataHelper;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }



    public static String getExcelDataPath() {
        excelDataPath = propertyManagerTest.getConfigData("ExcelFileName");
        return excelDataPath;
    }

    public SendEmailData getEmailData(){
        SendEmailData emailData = new SendEmailData();
        emailData.setMailSendTo(propertyManagerTest.getConfigData("MailSendTo"));
        return emailData;
    }

    public SendEmailHelper getSendEmailHelper() {
        if (sendEmailHelper==null) {
            sendEmailHelper = new SendEmailHelper(appManager);
        }
        return sendEmailHelper;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getExeToStart() {
        return exeToStart;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public static String getTestName() {
        return testName;
    }

    public static void pause(int t) throws InterruptedException {
            Thread.sleep(t);
    }
}
