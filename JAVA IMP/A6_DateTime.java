
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class A6_DateTime {
    public static void main(String[] args) {
        // Current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);
        // Expected output: Current Date: 2024-10-06 (assuming today's date)

        // Specific date creation
        LocalDate specificDate = LocalDate.of(2020, Month.JANUARY, 1);
        System.out.println("Specific Date: " + specificDate);
        // Expected output: Specific Date: 2020-01-01

        // Current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);
        // Expected output: Current Time: 14:30:45.123456789 (example time)

        // Specific time creation
        LocalTime specificTime = LocalTime.of(10, 30, 45);
        System.out.println("Specific Time: " + specificTime);
        // Expected output: Specific Time: 10:30:45

        // Current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);
        // Expected output: Current Date and Time: 2024-10-06T14:30:45.123456789

        // Formatting date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);
        // Expected output: Formatted Date: 06/10/2024

        // Adding days to a date
        LocalDate newDate = currentDate.plusDays(10);
        System.out.println("Date after 10 days: " + newDate);
        // Expected output: Date after 10 days: 2024-10-16

        // Subtracting days from a date
        LocalDate previousDate = currentDate.minusDays(5);
        System.out.println("Date 5 days ago: " + previousDate);
        // Expected output: Date 5 days ago: 2024-10-01

        // Duration between two times
        LocalTime startTime = LocalTime.of(9, 0, 0);
        LocalTime endTime = LocalTime.of(17, 0, 0);
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Duration between " + startTime + " and " + endTime + ": " + duration.toHours() + " hours");
        // Expected output: Duration between 09:00 and 17:00: 8 hours

        // Period between two dates
        LocalDate date1 = LocalDate.of(2020, Month.JANUARY, 1);
        LocalDate date2 = LocalDate.of(2021, Month.JANUARY, 1);
        Period period = Period.between(date1, date2);
        System.out.println("Period between " + date1 + " and " + date2 + ": " + period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days");
        // Expected output: Period between 2020-01-01 and 2021-01-01: 1 years, 0 months, 0 days

        // Difference between two dates in days
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("Days between " + date1 + " and " + date2 + ": " + daysBetween + " days");
        // Expected output: Days between 2020-01-01 and 2021-01-01: 366 days

        // Difference between two times in seconds
        long secondsBetween = ChronoUnit.SECONDS.between(startTime, endTime);
        System.out.println("Seconds between " + startTime + " and " + endTime + ": " + secondsBetween + " seconds");
        // Expected output: Seconds between 09:00 and 17:00: 28800 seconds

        // Current timestamp
        Instant now = Instant.now();
        System.out.println("Current Timestamp: " + now);
        // Expected output: Current Timestamp: 2024-10-06T14:30:45.123456789Z

        // Convert timestamp to LocalDateTime
        LocalDateTime dateTimeFromTimestamp = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println("Converted LocalDateTime from Timestamp: " + dateTimeFromTimestamp);
        // Expected output: Converted LocalDateTime from Timestamp: 2024-10-06T14:30:45.123456789

        // Example of parsing a date string
        String dateString = "2024-10-06";
        LocalDate parsedDate = LocalDate.parse(dateString);
        System.out.println("Parsed Date: " + parsedDate);
        // Expected output: Parsed Date: 2024-10-06

        // Working with ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Current date and time with time zone: " + zonedDateTime);
        // Expected output: Current date and time with time zone: 2024-10-06T14:30:45.123456789+01:00[Europe/London]

        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Current time in New York: " + newYorkTime);
        // Expected output: Current time in New York: 2024-10-06T09:30:45.123456789-04:00[America/New_York]

        // Using TemporalAdjusters
        LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("First day of current month: " + firstDayOfMonth);
        // Expected output: First day of current month: 2024-10-01

        LocalDate lastDayOfYear = LocalDate.now().with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last day of current year: " + lastDayOfYear);
        // Expected output: Last day of current year: 2024-12-31

        // Checking if a year is a leap year
        boolean isLeapYear = Year.now().isLeap();
        System.out.println("Is current year a leap year? " + isLeapYear);
        // Expected output: Is current year a leap year? true

        // Getting day of week
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        System.out.println("Current day of week: " + dayOfWeek);
        // Expected output: Current day of week: SUNDAY

        // Formatting with locales
        LocalDate date = LocalDate.now();
        DateTimeFormatter germanFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.GERMAN);
        System.out.println("Date in German format: " + date.format(germanFormatter));
        // Expected output: Date in German format: 6. Oktober 2024

        // Working with MonthDay
        MonthDay christmasEve = MonthDay.of(12, 24);
        System.out.println("Christmas Eve: " + christmasEve);
        // Expected output: Christmas Eve: --12-24

        // Using YearMonth
        YearMonth currentYearMonth = YearMonth.now();
        System.out.println("Days in current month: " + currentYearMonth.lengthOfMonth());
        // Expected output: Days in current month: 31

        // Parsing and formatting custom date-time
        String dateTimeString = "2023-03-15T10:15:30+01:00[Europe/Paris]";
        ZonedDateTime parsedZonedDateTime = ZonedDateTime.parse(dateTimeString);
        System.out.println("Parsed ZonedDateTime: " + parsedZonedDateTime);
        // Expected output: Parsed ZonedDateTime: 2023-03-15T10:15:30+01:00[Europe/Paris]

        // Getting time zone offset
        ZoneOffset offset = ZonedDateTime.now().getOffset();
        System.out.println("Current time zone offset: " + offset);
        // Expected output: Current time zone offset: +01:00

        // Truncating time
        LocalTime truncatedTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        System.out.println("Time truncated to minutes: " + truncatedTime);
        // Expected output: Time truncated to minutes: 14:30
    }
}