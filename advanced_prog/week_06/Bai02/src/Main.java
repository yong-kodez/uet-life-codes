public class Main {
    public static void main(String[] args) {
        NotificationApp emailApp = new EmailApp();
        NotificationApp smsApp = new SmsApp();

        emailApp.notifyUser("Class cancel due to heavy rain");
        smsApp.notifyUser("Advertise...");
    }
}
