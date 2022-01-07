public class ContextAutoPlay {

    public AutomaticModel automaticModel;

    public ContextAutoPlay(AutomaticModel player) {
        this.automaticModel = player;
    }

    public void execute() {
        automaticModel.playAuto();
    }

}
