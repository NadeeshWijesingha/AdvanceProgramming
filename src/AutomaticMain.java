public class AutomaticMain {
    public static void main(String[] args) {
        ContextAutoPlay contextAutoPlay = new ContextAutoPlay(new FirstPlayer());
        contextAutoPlay.execute();

        contextAutoPlay = new ContextAutoPlay(new SecondPlayer());
        contextAutoPlay.execute();

        contextAutoPlay = new ContextAutoPlay(new ThirdPlayer());
        contextAutoPlay.execute();

    }
}
