package testcodes.date.api;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateApiDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate local = LocalDate.now();
		System.out.println(local);
		System.out.println(local.plusDays(1));
		System.out.println(local.getDayOfWeek());
		
		boolean notBefore = LocalDate.parse("2016-06-12")
				  .isBefore(LocalDate.parse("2016-06-11"));
		System.out.println(notBefore);
		//------------
		LocalTime now = LocalTime.now();
		System.out.println(now);
	}

}
