package utilities;

import java.io.IOException;

public class ApplicationProcessHelper {
    private static Process runProcess;
    static ApplicationManager appManager;
    public ApplicationProcessHelper(ApplicationManager appManager) {
        this.appManager=appManager;
        try {
            runProcess = new ProcessBuilder(appManager.getExeToStart()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Process getRunProcess() {
        if (runProcess == null) {
            new ApplicationProcessHelper(appManager);
        }
        return runProcess;
    }

    public void dismiss(String exeToKill){
        if (runProcess!=null){
            Log.info("process dismised");
            runProcess.destroy();
            appManager.taskKill(exeToKill);

        }
        runProcess=null;
    }
}
