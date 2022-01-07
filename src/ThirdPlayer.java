public class ThirdPlayer implements AutomaticModel {
    @Override
    public void playAuto() {
        Aardvark aardvark = new Aardvark(3);
        aardvark.playerName = "Third Player";
        aardvark.play();
    }
}
