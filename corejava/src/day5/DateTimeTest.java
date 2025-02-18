package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.junit.jupiter.api.Test;

class DateTimeTest {

	@Test
	void test() throws ParseException {
		Date now=new Date();
		System.out.println(now);
		Date independenceDay=new Date(47,7,15);
		System.out.println(independenceDay);
		/*
		 * yyyy ->year  yy
		 * MM-> numeric Month MM ->alpha
		 * dd ->day
		 * Hour ->hh
		 * Minute ->mm
		 * Seconds->ss
		 */
		java.text.DateFormat df= new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(df.format(independenceDay));
		Date republicDay=df.parse("26-01-1950");
		System.out.println(republicDay);
	}

}
