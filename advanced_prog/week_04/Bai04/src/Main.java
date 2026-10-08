interface IData {
    void show();
}

class DataManager implements IData {
    // void show() {
    public void show() {
        System.out.println("Show data");
    }
}

public class Main {
    public static void main(String[] args) {
        DataManager dm = new DataManager();
        dm.show();
    }
}
