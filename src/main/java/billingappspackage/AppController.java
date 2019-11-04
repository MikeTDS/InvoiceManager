package billingappspackage;

public class AppController {
    public AppWindow appWindow;
    public DataController dataController;
    AppController(){
        dataController = new DataController(this);
        appWindow=new AppWindow(this);
    }
}
