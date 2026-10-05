public class Message {
    private int id;
    private String content;

    private static int tick = 1;
    
    public Message(String content) {
        this.id = tick;
        this.content = content;
        tick++;
    }

    public String getContent() { return this.content; }
}
