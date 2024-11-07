package dateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SystemDateAndFormat {
    public static void main(String[] args) {
    	//Date in system format
		Date dateObj = new Date();
		System.out.println(dateObj.toString());
		
		//Todays date in format
		SimpleDateFormat sim = new SimpleDateFormat("YYYY-MM-dd");
		String todaysDate = sim.format(dateObj);
		System.out.println(todaysDate);
		
		//Date after 30 days from now
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String dataAfter30days = sim.format(cal.getTime());
		System.out.println(dataAfter30days);
	}
}
