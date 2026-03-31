import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
public class TimeZone {
    public static void main(String[] args) {
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");
        ZonedDateTime gmtTime =ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime istTime =ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime pstTime =ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("Current Time in Different Time Zones");
        System.out.println("GMT : " + gmtTime.format(formatter));
        System.out.println("IST : " + istTime.format(formatter));
        System.out.println("PST : " + pstTime.format(formatter));
    }
}
