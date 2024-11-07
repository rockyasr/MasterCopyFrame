package dateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarClassAndItsMethods {
	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1; // Months are 0- based,so add one;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "-" + month + "-" + day);

		// Day after 30 days in system date format
		calendar.add(Calendar.DAY_OF_MONTH, 30);
		System.out.println(calendar.getTime());

		calendar.add(Calendar.MONTH, -1);
		System.out.println(calendar.getTime());

		calendar.roll(Calendar.DAY_OF_MONTH, 10);
		System.out.println(calendar.getTime());

		Date dateobj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateobj);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String reqDate = sim.format(cal.getTime());
		System.out.println(reqDate);
	}
}
