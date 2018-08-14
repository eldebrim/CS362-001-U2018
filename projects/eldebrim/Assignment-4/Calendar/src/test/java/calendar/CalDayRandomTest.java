package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;


import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"addAppt"};// The list of the of methods to be tested in the CalDay class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur
        }
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur
        }
   /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);


				 int startHour1=ValuesGenerator.getRandomIntBetween(random, -1, 61);
				 int startMinute1=ValuesGenerator.getRandomIntBetween(random, -1, 61);
				 int startDay1=ValuesGenerator.getRandomIntBetween(random, -1, 34);
				 int startMonth1=ValuesGenerator.getRandomIntBetween(random, -1, 13);
				 int startYear1=ValuesGenerator.getRandomIntBetween(random, -1, 2018);

				 int startHour2=ValuesGenerator.getRandomIntBetween(random, -1, 61);
				 int startMinute2=ValuesGenerator.getRandomIntBetween(random, -1, 100);
				 int startDay2=ValuesGenerator.getRandomIntBetween(random, -1, 34);
				 int startMonth2=ValuesGenerator.getRandomIntBetween(random, -1, 13);
				 int startYear2=ValuesGenerator.getRandomIntBetween(random, -1, 2018);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";
				CalDay cal = new CalDay(new GregorianCalendar(1, 1, 1));

				 //Construct a new Appointment object with the initial data
				 //Construct a new Appointment object with the initial data
		         Appt appt1 = new Appt(startHour1,
		                  startMinute1,
		                  startDay1,
		                  startMonth1,
		                  startYear1,
		                  title,
		                 description,
		                 emailAddress);

		         Appt appt2 = new Appt(startHour2,
		                  startMinute2,
		                  startDay2,
		                  startMonth2,
		                  startYear2,
		                  title,
		                 description,
		                 emailAddress);

			/* if(!appt1.getValid()){
				 cal.addAppt(appt1);
				 cal.addAppt(null);
				 continue;
			 */ 
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = CalDayRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("addAppt")){
			                           appt1.setValid();
			                           appt2.setValid();
						   cal.addAppt(appt1);
						   cal.addAppt(appt2);
					   }
			                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                                        if((iteration%10000)==0 && iteration!=0 )
                                            System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}
		}catch(NullPointerException e){
		}
	}
}
