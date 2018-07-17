
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  DataHandler dhandler0 = new DataHandler();
	  assertTrue(dhandler0.saveAppt(new Appt(3, 3, 3, 3, 3, "", "", "")));
	  Appt appt = new Appt(29, 3, 3, 3, 3, "", "", "");
          appt.setValid();
	  dhandler0.getApptRange(new GregorianCalendar(1, 1, 1), new GregorianCalendar(4, 4, 4));
	  assertFalse(dhandler0.saveAppt(appt));
	  assertFalse(dhandler0.deleteAppt(appt));

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  DataHandler dhandler1 = new DataHandler("test.xml", true);
	  Appt appt = new Appt(2, 3, 14, 3, 3, "", "", "");
          appt.setValid();
	  int[] recurDays = {9, 12, 15, 20};
          appt.setRecurrence(recurDays, 1, 1, 1);
	  assertTrue(dhandler1.saveAppt(appt));
	  dhandler1.getApptRange(new GregorianCalendar(1, 1, 1), new GregorianCalendar(4, 4, 4));
	  assertTrue(dhandler1.deleteAppt(appt));

  }
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
	  DataHandler dhandler2 = new DataHandler("test.xml");
	  Appt appt = new Appt(2, 3, 14, 1, 1, "", "", "");
          appt.setValid();
	  int[] recurDays = {9, 12, 15, 20};
          appt.setRecurrence(recurDays, 2, 1, 1);
	  assertTrue(dhandler2.saveAppt(appt));
	  dhandler2.getApptRange(new GregorianCalendar(1, 1, 1), new GregorianCalendar(100, 10, 11));
	  assertTrue(dhandler2.deleteAppt(appt));

  }
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
	  DataHandler dhandler3 = new DataHandler("test.xml", false);
	  Appt appt = new Appt(2, 3, 14, 5, 5, "", "", "");
          appt.setValid();
	  int[] recurDays = {};
          appt.setRecurrence(recurDays, 1, 1, 1);
	  assertTrue(dhandler3.saveAppt(appt));
	  dhandler3.getApptRange(new GregorianCalendar(1, 1, 1), new GregorianCalendar(4, 4, 4));
	  assertTrue(dhandler3.deleteAppt(appt));
  }
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
	  DataHandler dhandler4 = new DataHandler("test.xml", false);
	  Appt appt = new Appt(2, 3, 14, 2, 2, "", "", "");
          appt.setValid();
	  int[] recurDays = {};
          appt.setRecurrence(recurDays, 3, 1, 1);
	  assertTrue(dhandler4.saveAppt(appt));
	  dhandler4.getApptRange(new GregorianCalendar(1, 1, 1), new GregorianCalendar(4, 4, 4));
	  assertTrue(dhandler4.deleteAppt(appt));
  }
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
	  DataHandler dhandler5 = new DataHandler("test.xml", false);
	  Appt appt = new Appt(2, 3, 14, 2, 2, "", "", "");
          appt.setValid();
	  int[] recurDays = {};
          appt.setRecurrence(recurDays, 1, 1, 1);
	  assertTrue(dhandler5.saveAppt(appt));
	  dhandler5.getApptRange(new GregorianCalendar(1, 1, 1), new GregorianCalendar(4, 4, 4));
	  assertTrue(dhandler5.deleteAppt(appt));
  }
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
	  DataHandler dhandler6 = new DataHandler("test.xml", false);
	  Appt appt = new Appt(2, 3, 14, 2, 2, "", "", "");
          appt.setValid();
	  int[] recurDays = {9, 12};
          appt.setRecurrence(recurDays, 8, 1, 1);
	  assertTrue(dhandler6.saveAppt(appt));
	  dhandler6.getApptRange(new GregorianCalendar(1, 1, 1), new GregorianCalendar(4, 4, 4));
	  assertTrue(dhandler6.deleteAppt(appt));
  }
  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
	  DataHandler dhandler7 = new DataHandler("test.xml", false);
	  Appt appt = new Appt(2, 3, 14, 2, 2, "", "", "");
          appt.setValid();
	  int[] recurDays = {9, 12};
          appt.setRecurrence(recurDays, 1, 1, 1);
	  assertTrue(dhandler7.saveAppt(appt));
	  dhandler7.getApptRange(new GregorianCalendar(2, 2, 14), new GregorianCalendar(4, 4, 4));
	  assertTrue(dhandler7.deleteAppt(appt));
  }

}
