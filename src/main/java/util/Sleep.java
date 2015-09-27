package util;

public class Sleep {
    public static void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
