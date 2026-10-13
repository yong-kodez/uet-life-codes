public class MediaPlayer implements AudioPlayable, VideoPlayable {
    private AudioPlayer audio;
    private VideoPlayer video;

    public MediaPlayer(AudioPlayer audio, VideoPlayer video) {
        this.audio = audio;
        this.video = video;
    }

    @Override
    public void playAudio(String file) {
        audio.playAudio(file);
    }

    @Override
    public void playVideo(String file) {
        video.playVideo(file);
    }
}
