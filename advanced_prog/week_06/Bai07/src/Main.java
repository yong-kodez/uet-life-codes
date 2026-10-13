public class Main {
    public static void main(String[] args) {
        Notifier noti = new SMSNotifier(
            new FacebookNotifier(
            new EmailNotifier())); 
        noti.send("14 games you've wished for is on sale!");
    }
}
