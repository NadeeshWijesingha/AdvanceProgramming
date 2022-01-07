public class MVCController {
    private MVCModel model;
    private MVCView view;

    public MVCController(MVCModel model, MVCView view){
        this.model = model;
        this.view = view;
    }

    public void setPlayerName(String playerName){
        model.setName(playerName);
    }

    public String getPlayerName(){
        return model.getName();
    }

    public void updateView() {
        view.mvcMainGUI();
    }
}
