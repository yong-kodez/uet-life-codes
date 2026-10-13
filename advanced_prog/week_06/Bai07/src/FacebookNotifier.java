public class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Sent to Facebook: " + msg);
    }
}
