package util;

import static java.lang.System.out;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilTime {
	
	private static Instant start;
	private static Instant finish;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:ss");
	
	private UtilTime() {}
	
	public static void start() {
		start = Instant.now();
		out.println(start);
//		out.println(formatter.format(start));
	}

	public static void end() {
		finish = Instant.now();
		out.println(finish);
//		out.println(formatter.format(finish));
		
		out.println(Duration.between(start, finish));

	
	}
	
}
