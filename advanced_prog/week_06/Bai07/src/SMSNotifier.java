public class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Sent to SMS: " + msg);
    }
}
