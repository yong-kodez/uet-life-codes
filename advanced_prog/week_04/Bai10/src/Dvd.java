public class Dvd extends MediaItem {
    private String director;
    private int duration;

    public Dvd(String id, String name, String director, int duration) {
        super(id, name);
        this.director = director;
        this.duration = duration;
    }

    public String getDirector() { return this.director; }
    public int getDuration() { return this.duration; }

    @Override
    public String detail() {
        return super.detail() + this.getDirector() + " - " + this.getDuration();
    }
}
