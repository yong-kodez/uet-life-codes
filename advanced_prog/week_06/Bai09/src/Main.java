public class Main {
    public static void main(String[] args) {
        AudioPlayer ap = new AudioPlayer();
        VideoPlayer vp = new VideoPlayer();
        MediaPlayer mp = new MediaPlayer(ap, vp);

        mp.playAudio("Be Better");
        mp.playVideo("What are design patterns?");
    }
}
