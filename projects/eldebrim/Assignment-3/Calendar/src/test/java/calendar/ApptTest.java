/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt0.setValid();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals(0, appt0.getRecurIncrement());
      assertEquals("Birthday Party",appt0.getTitle());
      assertTrue(!appt0.getValid());
      assertEquals(15, appt0.getStartHour());
      /*assertEquals(30, appt0.getStartMinute());*/
      assertEquals(9, appt0.getStartDay());
      assertEquals(14, appt0.getStartMonth());
      assertEquals(2018, appt0.getStartYear());
     /* assertEquals("This is my birthday party", appt0.getDescription()); */
      assertEquals("xyz@gmail.com", appt0.getEmailAddress());
      assertEquals(null, appt0.getXmlElement());
      assertTrue(appt0.isOn(9, 14, 2018));
      assertTrue(appt0.hasTimeSet());
      
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
      Appt appt1 = new Appt(-1, -30, -9, -14, -2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt1.setValid();
      int[] recurDays = new int[4];
      appt1.setRecurrence(recurDays, 1, 1, 1);
      assertTrue(recurDays == appt1.getRecurDays());
      assertFalse(appt1.getValid());
      assertTrue(appt1.isRecurring());
      appt1.setRecurrence(null , 1, 1, 1);
      assertTrue(appt1.isRecurring());
      assertFalse(appt1.isOn(9, 14, 2019));



}

@Test(timeout = 4000)
 public void test02()  throws Throwable  {
      Appt appt2 = new Appt(5, 10, 9, 2, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt2.setValid();
      assertTrue(appt2.getValid());
 }
@Test(timeout = 4000)
 public void test03()  throws Throwable  {
      Appt appt3 = new Appt(25, 59, 9, 2, 1018, null, null, null);
      appt3.setValid();
      assertFalse(appt3.getValid());
      assertEquals("", appt3.getTitle());
      assertEquals("", appt3.getDescription());
      assertEquals("", appt3.getEmailAddress());
      assertFalse(appt3.isOn(10, 2, 1018));
 }
@Test(timeout = 4000)
 public void test04()  throws Throwable  {
      Appt appt4 = new Appt(9, 2, 0, null, null, null);
      appt4.setValid();
      assertFalse(appt4.getValid());
      assertEquals(-1, appt4.getStartMinute());
      assertFalse(appt4.hasTimeSet());
      assertEquals("\t2/9/0 at -1:-1am ,, \n", appt4.toString());
 }
@Test(timeout = 4000)
 public void test05()  throws Throwable  {
      Appt appt5 = new Appt(5, 20, 9, 2, -3, null, null, null);
      appt5.setValid();
      assertFalse(appt5.getValid());
 }
@Test(timeout = 4000)
 public void test06()  throws Throwable  {
      Appt appt6 = new Appt(5, 20, 41, 2, 2018, null, null, null);
      appt6.setValid();
      assertFalse(appt6.getValid());
      assertFalse(appt6.isOn(41, 3, 2018));
 }
@Test(timeout = 4000)
 public void test07()  throws Throwable  {
      Appt appt7 = new Appt(5, 20, 0, 2, 2018, null, null, null);
      appt7.setValid();
      assertFalse(appt7.getValid());
      assertFalse(appt7.isOn(0, 2, 2019));
 }
}
