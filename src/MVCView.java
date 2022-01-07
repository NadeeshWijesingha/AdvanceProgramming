public class MVCView {
    public void mvcMainGUI() {
        ObserverSubject os = new ObserverSubject();

        new ObserverStartGame(os);
        new ObserverPlayer(os);
        new ObserverMainMenu(os);
        new ObserverDifficultyMenu(os);

        os.notifyAllObservers();
    }
}
