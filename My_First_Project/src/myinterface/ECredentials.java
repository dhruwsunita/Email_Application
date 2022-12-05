package myinterface;

import mymodel.MyEmployee;

public interface ECredentials {
	
     String generateEmailAddress(MyEmployee emp);
	
     String generatePassword(int length);

	 void showCredentials(MyEmployee emp);	 

}
