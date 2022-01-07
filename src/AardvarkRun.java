public class AardvarkRun {
    public static void main(String[] args) {
        MVCModel mvcModel = new MVCModel();
        MVCView mvcView = new MVCView();
        MVCController mvcController = new MVCController(mvcModel, mvcView);
        mvcController.updateView();
    }
}
