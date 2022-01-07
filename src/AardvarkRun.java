public class AardvarkRun {
    public static void main(String[] args) {
        MVCModel model = new MVCModel();
        MVCView view = new MVCView();
        MVCController controller = new MVCController(model, view);
        controller.updateView();
    }
}
