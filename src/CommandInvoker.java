public class CommandInvoker {
    private final Command placeDomino;

    public CommandInvoker(CommandPlaceDomino aardvarkPlaceDominoCommand) {
        this.placeDomino = aardvarkPlaceDominoCommand;
    }

    public void forwardGame() {
        placeDomino.play();
    }

    public void backwardGame() {
        placeDomino.undo();
    }
}
