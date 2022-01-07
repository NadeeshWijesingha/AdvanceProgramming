public class SecondPlayer implements AutomaticModel {
    @Override
    public void playAuto() {
        Aardvark aardvark = new Aardvark(2);
        aardvark.playerName = "Second Player";
        aardvark.play();
    }
}
