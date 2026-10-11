public abstract class NotificationApp {
    public void notifyUser(String msg) {
        Notification noti = createNotification();
        noti.send(msg);
    }

    public abstract Notification createNotification();
}
