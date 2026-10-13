public class EmailNotifier implements Notifier {
    @Override
    public void send(String msg) {
        System.out.println("Sent to Email: " + msg);
    }
}
