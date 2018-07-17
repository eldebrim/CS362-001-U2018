/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;

import java.util.GregorianCalendar;

public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  CalDay cal = new CalDay(new GregorianCalendar(100, 2, 1));
	  assertEquals(1, cal.getDay());
	  //assertEquals(2, cal.getMonth());
	  assertEquals(100, cal.getYear());
	  assertTrue(cal.isValid());
	  assertEquals("3-1-100 ", cal.getFullInfomrationApp(cal));
	  cal.toString();

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  CalDay cal1 = new CalDay(new GregorianCalendar(100, 2, 1));
	  Appt appt = new Appt(2, 3, 14, 3, 3, "", "", "");
	  cal1.addAppt(appt);
          cal1.getFullInfomrationApp(cal1);
  }
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
	  CalDay cal2 = new CalDay(new GregorianCalendar(100, 2, 1));
	  Appt appt = new Appt(0, 21, 14, 3, 3, "", "", "");
	  cal2.addAppt(appt);
          cal2.getFullInfomrationApp(cal2);
	  cal2.toString();
  }
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
	  CalDay cal3 = new CalDay(new GregorianCalendar(100, 2, 1));
	  Appt appt = new Appt(10, 2, 14, 3, 3, "", "", "");
	  cal3.addAppt(appt);
          cal3.getFullInfomrationApp(cal3);
	  cal3.toString();
  }
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
	  CalDay cal4 = new CalDay(new GregorianCalendar(100, 2, 1));
	  Appt appt = new Appt(30, -2, 14, 3, 3, "", "", "");
	  cal4.addAppt(appt);
          cal4.getFullInfomrationApp(cal4);
	  cal4.toString();
  }
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
	  CalDay cal5 = new CalDay(new GregorianCalendar(100, 2, 1));
	  Appt appt = new Appt(14, 3, 3, "", "", "");
	  cal5.addAppt(appt);
          cal5.getFullInfomrationApp(cal5);
	  cal5.toString();
  }
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
	  CalDay cal6 = new CalDay();
	  Appt appt = new Appt(14, 3, 3, "", "", "");
	  cal6.toString();
  }

}
