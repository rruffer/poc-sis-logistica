package util;

import static java.lang.System.out;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UtilDate {
	
	private static Instant start;
	private static Instant finish;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:ss");
	
	private UtilDate() {}
	
	public static void start() {
		start = Instant.now();
		out.println(start);
	}

	public static void end() {
		finish = Instant.now();
		out.println(finish);
		out.println(Duration.between(start, finish));
	}

	public static LocalDate converterDateEmLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static LocalDateTime converterDateEmLocalDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
}
