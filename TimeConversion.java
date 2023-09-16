import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {

    public static void main(String[] args) {
        // Get the current time in UTC
        LocalDateTime utcTime = LocalDateTime.now();

        // Convert the UTC time to a specified time zone (e.g., New York)
        String targetTimeZone = "America/New_York";
        ZonedDateTime convertedTime = convertToTimeZone(utcTime, targetTimeZone);

        // Display the converted time in the target time zone
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = convertedTime.format(formatter);
        System.out.println("Converted time in " + targetTimeZone + ": " + formattedTime);
    }

    public static ZonedDateTime convertToTimeZone(LocalDateTime utcTime, String targetTimeZone) {
        // Convert LocalDateTime to ZonedDateTime with UTC time zone
        ZonedDateTime utcDateTime = ZonedDateTime.of(utcTime, ZoneId.of("UTC"));

        // Convert the UTC time to the target time zone
        return utcDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone));
    }
}
