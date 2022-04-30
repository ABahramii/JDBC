public class Main {
    public static void main(String[] args) throws InterruptedException {
        DBHandler dbHandler = new DBHandler();

        dbHandler.open();
        Thread.sleep(5 * 1000);
        dbHandler.close();
    }
}
