public class MVCView {
    public void mvcMainGUI() {
        ObserverSubject observerSubject = new ObserverSubject();

        new ObserverStartGame(observerSubject);
        new ObserverPlayer(observerSubject);
        new ObserverMainMenu(observerSubject);
        new ObserverDifficultyMenu(observerSubject);

        observerSubject.notifyAllObservers();
    }
}
