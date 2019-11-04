package billingappspackage;

import billingappspackage.datacontrollers.DataController;
import billingappspackage.window.AppWindow;

public class AppController {
    public final AppWindow appWindow;
    public final DataController dataController;
    AppController(){
        dataController = new DataController(this);
        appWindow=new AppWindow(this);
    }
}
