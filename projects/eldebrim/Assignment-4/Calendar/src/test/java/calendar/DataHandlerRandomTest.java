package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;


import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"getApptRange", "deleteAppt"};// The list of the of methods to be tested in the DataHandler class

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
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

		try{

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

			 DataHandler dhandler1 = new DataHandler("test.xml", ValuesGenerator.getBoolean(0.50f, random));

			/* if(!appt1.getValid()){
				 cal.addAppt(appt1);
				 cal.addAppt(null);
				 continue;
			 */ 
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = DataHandlerRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("getApptRange")){
						int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						int recur=ApptRandomTest.RandomSelectRecur(random);
						int recurIncrement = ValuesGenerator.RandInt(random);
						int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						appt1.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						dhandler1.saveAppt(appt1);
						dhandler1.saveAppt(appt2);
					   	dhandler1.getApptRange(new GregorianCalendar(ValuesGenerator.getRandomIntBetween(random, 1, 61), 1, 1), new GregorianCalendar(30, 4, 4));

					   }
					   else if (methodName.equals("deleteAppt")){
						appt1.setValid();
			                        DataHandler dhandler2 = new DataHandler("test2.xml", ValuesGenerator.getBoolean(0.50f, random));
						dhandler1.saveAppt(appt1);
						dhandler2.saveAppt(appt1);
						dhandler2.saveAppt(appt2);
						dhandler1.deleteAppt(appt1);
						dhandler1.deleteAppt(appt2);
						dhandler2.deleteAppt(appt2);
						dhandler2.deleteAppt(appt1);
					   
					   }
			                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                                        if((iteration%10000)==0 && iteration!=0 )
                                            System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		
		}catch(DateOutOfRangeException ex){
		}
	}
			}
}
