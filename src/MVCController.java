public class MVCController {
    private final MVCModel model;
    private final MVCView view;

    public MVCController(MVCModel model, MVCView view) {
        this.model = model;
        this.view = view;
    }

    public String getName() {
        return model.getName();
    }

    public void setName(String name) {
        model.setName(name);
    }

    public void updateView() {
        view.mvcMainGUI();
    }
}
