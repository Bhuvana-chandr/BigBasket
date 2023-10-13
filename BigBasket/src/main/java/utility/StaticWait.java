package utility;

public class StaticWait {

    public static void waitForSeconds(int threedSleepSeconds){
        try {
            Thread.sleep(threedSleepSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
