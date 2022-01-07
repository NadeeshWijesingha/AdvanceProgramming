public class FirstPlayer implements AutomaticModel {
    @Override
    public void playAuto() {
        Aardvark aardvark = new Aardvark(1);
        aardvark.playerName = "First Player";
        aardvark.play();
    }
}
