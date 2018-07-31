/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.*;

import java.util.GregorianCalendar;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNot.not;

public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  CalDay cal = new CalDay(new GregorianCalendar(100, 2, 1));
	  assertEquals(1, cal.getDay());
	  //assertEquals(2, cal.getMonth());
	  assertEquals(100, cal.getYear());
	  assertTrue(cal.isValid());
	  assertEquals("3-1-100 ", cal.getFullInfomrationApp(cal));
	  assertThat(cal.toString(), containsString("3"));

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
	  CalDay cal3 = new CalDay(new GregorianCalendar(30, 2, 4));
	  Appt appt = new Appt(5, 10, 14, 3, 3, "", "", "");
	  cal3.addAppt(appt);
	  assertThat(cal3.getFullInfomrationApp(cal3), containsString("10"));
	  cal3.toString();
  }
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
	  CalDay cal4 = new CalDay(new GregorianCalendar(100, 2, 1));
	  Appt appt1 = new Appt(0, 2, 14, 4, 4, "", "", "");
	  cal4.addAppt(appt1);
	  assertThat(cal4.getFullInfomrationApp(cal4), containsString("12"));
	  Appt appt2 = new Appt(15, 2, 19, 4, 4, "", "", "");
	  cal4.addAppt(appt2);
	  assertThat(cal4.getFullInfomrationApp(cal4), containsString("3"));
	  assertThat(cal4.toString(), containsString("100"));
  }
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
	  CalDay cal5 = new CalDay(new GregorianCalendar(100, 2, 1));
	  Appt appt1 = new Appt(10, 20, 14, 3, 3, "", "", "");
	  cal5.addAppt(appt1);
	  Appt appt2 = new Appt(5, 20, 12, 3, 3, "", "", "");
	  Appt appt3 = new Appt(10, 20, 12, 3, 3, "", "", "");
	  cal5.addAppt(appt2);
	  cal5.addAppt(appt3);
	  Iterator iter = cal5.iterator();
          assertEquals((Appt)iter.next(), appt2);
          assertEquals((Appt)iter.next(), appt1);
          assertEquals((Appt)iter.next(), appt3);
	  assertEquals(cal5.getSizeAppts(), 3);
	  assertThat(cal5.getFullInfomrationApp(cal5), containsString("PM"));
          cal5.getFullInfomrationApp(cal5);
	  cal5.toString();
  }
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
	  CalDay cal6 = new CalDay();
	  assertFalse(cal6.isValid());
	  assertEquals(cal6.iterator(), null);
	  cal6.toString();
  }
  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
	  CalDay cal7 = new CalDay(new GregorianCalendar(100, 6, 1));
	  Appt appt1 = new Appt(12, 3, 3, 3, 3, "", "", "");
	  cal7.addAppt(appt1);
	  assertThat(cal7.getFullInfomrationApp(cal7), containsString("AM"));
	  assertThat(cal7.getFullInfomrationApp(cal7), containsString("03"));
	  assertThat(cal7.getFullInfomrationApp(cal7), containsString("7"));
  }
  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
	  CalDay cal8 = new CalDay(new GregorianCalendar(100, 2, 1));
	  Appt appt1 = new Appt(16, 3, 3, 3, 3, "", "", "");
	  cal8.addAppt(appt1);
	  assertThat(cal8.getFullInfomrationApp(cal8), containsString("4"));
  }
  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
	  CalDay cal9 = new CalDay(new GregorianCalendar(2, 2, 1));
	  Appt appt1 = new Appt(16, 10, 3, 3, 3, "", "", "");
	  cal9.addAppt(appt1);
	  assertThat(cal9.getFullInfomrationApp(cal9), not(containsString("010")));
  }

}
