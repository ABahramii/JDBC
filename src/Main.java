public class Main {
    public static void main(String[] args) throws InterruptedException {
        DBHandler dbHandler = new DBHandler();

        dbHandler.open();
        Thread.sleep(2 * 1000);
        dbHandler.close();
    }
}
