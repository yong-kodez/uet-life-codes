public class PlayerAdapter implements Player {
    private OldPlayer old;

    @Override
    public void play(String name) {
        old = new OldPlayer();
        old.playFile(name);
        System.out.println("- Playing " + name);
    }
}
