public abstract class NotifierDecorator implements Notifier {
    private Notifier wrapped;

    public NotifierDecorator(Notifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void send(String msg) {
        wrapped.send(msg);
    }
}
