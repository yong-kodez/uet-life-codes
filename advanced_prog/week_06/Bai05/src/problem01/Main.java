public class Main {
    public static void main(String[] args) {
        System.out.println("1) Singleton");
        Logger log = Logger.getInstance();
        Logger otherLog = Logger.getInstance();
        System.out.println("- Init log: " + log.hashCode());
        System.out.println("- Another log call: " + otherLog.hashCode());
        System.out.println();
    }
}
