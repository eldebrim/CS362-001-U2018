

package finalprojectB;


import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *

 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.
   int bugs = 0;

   public UrlValidatorTest(String testName) {
      super(testName);
   }
    
   
    public void testManualTest()
    {
	    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	    assertTrue(urlVal.isValid("http://www.amazon.com"));
	    assertTrue(urlVal.isValid("https://www.amazon.com"));
	    assertTrue(urlVal.isValid("ftp://www.amazon.com"));
	    assertTrue(urlVal.isValid("hts://www.amazon.com"));
	    assertFalse(urlVal.isValid(null));
	    assertFalse(urlVal.isValid("asdf"));
	    assertTrue(urlVal.isValid("file://localhost/etc/fstab")); //  bug in UrlValidator  

	    assertFalse(urlVal.isValid("https:/www.amazon.com")); // bug in DomainValidator class, line 165
   
   
    } 
   public void testSchemePartitions()
    {
	    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
            String[] schemes    = { "http://", "https://",  "ftp://", "h3t://" };
	    for(int i = 0; i < schemes.length; i++) {
		    assertTrue(urlVal.isValid(schemes[i] + "www.google.com"));
			    System.out.println(schemes[i] + "google.com");
                    if(!urlVal.isValid(schemes[i] + "google.com")) {
			    System.out.println(schemes[i] + "google.com");

		    }

	    } 
            String[] badSchemes    = { "http//", "http:/", "ftp:\\\\", "h3t",  };
	    for(int i = 0; i < badSchemes.length; i++) {
		    assertFalse(urlVal.isValid(badSchemes[i] + "google.com"));

	    } 
	
    } 
   public void testAuthorityPartitions()
    {
	    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
            String[] authorities    = { "www.google.com", "google.com",  "amazon.com", "127.0.0.1" };
	    for(int i = 0; i < authorities.length; i++) {
		    assertTrue(urlVal.isValid("http://" + authorities[i]));
                    if(urlVal.isValid("http://" + authorities[i])) {

		    }

	    } 
            String[] badAuthorities    = { "", "asdf", "1234"};
	    for(int i = 0; i < badAuthorities.length; i++) {
		    System.out.println("http://" + badAuthorities[i]);
		    assertFalse(urlVal.isValid("http://" + badAuthorities[i]));

	    } 
	
    } 
   public void testPortPartitions()
    {
	    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
           String[] ports    = { ":80", ":65535", "", ":0", "" };
	    for(int i = 0; i < ports.length; i++) {
		    assertTrue(urlVal.isValid("http://google.com" + ports[i]));

	    } 
            String[] badPorts    = { "asdf", "1234"};
	    for(int i = 0; i < badPorts.length; i++) {
		    System.out.println("http://" + badPorts[i]);
		    assertFalse(urlVal.isValid("http://google.com" + badPorts[i]));

	    } 
	
    } 
   public void testPathPartitions()
    {
	    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String[] paths =  { "/test1", "/test12", "/test/" };
	   String[] badPaths =  { "/..", "/../", "/../file" };
	    for(int i = 0; i < paths.length; i++) {
		    assertTrue(urlVal.isValid("http://google.com" + paths[i]));

	    } 
	    for(int i = 0; i < badPaths.length; i++) {
		    System.out.println("http://" + badPaths[i]);
		    assertFalse(urlVal.isValid("http://google.com" + badPaths[i]));

	    } 
	
    } 
   public void testIsValid()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String[] schemes    = { "http://", "https://",  "ftp://", "h3t://" };
           String[] authorities    = { "www.google.com", "google.com",  "amazon.com", "127.0.0.1" };
           String[] ports    = { ":80", ":65535", "", ":0" };
	   String[] paths =  { "/test1", "/test12", "/test/" };
	   String[] queries =  { "?action=view", "?action=edit&mode=up", ""  };

	   for (int i=0; i < schemes.length; i++) {
		   for (int j=0; j < authorities.length; j++) {
			   for (int k=0; k < ports.length; k++) {
				   for (int l =0; l < paths.length; l++) {
					   for (int m=0; m < queries.length; m++) {
						   System.out.println(schemes[i]+authorities[j]+ports[k]+paths[l]+queries[m]);
						if(urlVal.isValid(schemes[i]+authorities[j]+ports[k]+paths[l]+queries[m])) {
							bugs++;
						}
					   }
				   }
			   }
		   }
	   }
   }

   public void testIsNotValid()
   {
	    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String[] schemes    = { "http://", "https://",  "ftp://", "h3t://" };
           String[] authorities    = { "www.google.com", "google.com",  "amazon.com", "127.0.0.1" };
           String[] ports    = { ":80", ":65535", "", ":0" };
	   String[] paths =  { "/test1", "/test12", "/test/" };
	   String[] queries =  { "?action=view", "?action=edit&mode=up", ""  };

	   String[] badSchemes    = { "http//", "http/",  "ftp:/", "h3t" };
           String[] badAuthorities    = { "asdf", "", "266.266.266.266" };
           String[] badPorts    = { ":a80", "abc"};
	   String[] badPaths =  { "/..", "/../", "/../file" };
	   String[] badQueries =  { "\\?:"};
		

	   assertFalse(urlVal.isValid("1234asdf"));
	   assertFalse(urlVal.isValid(null));
	   for (int i=0; i < badSchemes.length; i++) {
		   for (int j=0; j < authorities.length; j++) {
			   for (int k=0; k < ports.length; k++) {
				   for (int l =0; l < paths.length; l++) {
					   for (int m=0; m < queries.length; m++) {
						if(urlVal.isValid(badSchemes[i]+authorities[j]+ports[k]+paths[l]+queries[m])) {
							bugs++;
						}
					   }
				   }
			   }
		   }
	   }
	   for (int i=0; i < schemes.length; i++) {
		   for (int j=0; j < badAuthorities.length; j++) {
			   for (int k=0; k < ports.length; k++) {
				   for (int l =0; l < paths.length; l++) {
					   for (int m=0; m < queries.length; m++) {
						if(urlVal.isValid(schemes[i]+badAuthorities[j]+ports[k]+paths[l]+queries[m])) {
							bugs++;
						}
					   }
				   }
			   }
		   }
	   }
	   for (int i=0; i < schemes.length; i++) {
		   for (int j=0; j < authorities.length; j++) {
			   for (int k=0; k < badPorts.length; k++) {
				   for (int l =0; l < paths.length; l++) {
					   for (int m=0; m < queries.length; m++) {
						if(urlVal.isValid(schemes[i]+authorities[j]+badPorts[k]+paths[l]+queries[m])) {
							bugs++;
						}
					   }
				   }
			   }
		   }
	   }
	   for (int i=0; i < schemes.length; i++) {
		   for (int j=0; j < authorities.length; j++) {
			   for (int k=0; k < ports.length; k++) {
				   for (int l =0; l < badPaths.length; l++) {
					   for (int m=0; m < queries.length; m++) {
						if(urlVal.isValid(schemes[i]+authorities[j]+ports[k]+badPaths[l]+queries[m])) {
							bugs++;
						}
					   }
				   }
			   }
		   }
	   }
	   for (int i=0; i < schemes.length; i++) {
		   for (int j=0; j < authorities.length; j++) {
			   for (int k=0; k < ports.length; k++) {
				   for (int l =0; l < paths.length; l++) {
					   for (int m=0; m < badQueries.length; m++) {
						if(urlVal.isValid(schemes[i]+authorities[j]+ports[k]+paths[l]+badQueries[m])) {
							bugs++;
						}
					   }
				   }
			   }
		   }
	   }
	   System.out.println(bugs + "bugs found");
   }
}
