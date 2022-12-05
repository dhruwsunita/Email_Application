package emailsevices;

import java.util.Random;

import myinterface.ECredentials;
import mymodel.MyEmployee;

public class CredentialServices implements ECredentials {
	
	private String cmpName;
	
	public  CredentialServices(String cmpName) {
		 this.cmpName = cmpName;
		
	}

	@Override
	public String generateEmailAddress(MyEmployee emp) {
		if (emp != null && ((emp.getFirstName() != null && !emp.getFirstName().isEmpty())
				|| emp.getLastName() != null && !emp.getLastName().isEmpty())) {
			return emp.getFirstName().toLowerCase() + emp.getLastName().toLowerCase()+"@" + emp.getDepartment()+"."+cmpName;
		} 
		else {
			System.out.println("Invalid Entry!");
		}
		return null; 
		
	}

	
	@Override
	public void showCredentials(MyEmployee emp) {
		    System.out.println("Dear "+emp.getFirstName()+" your generated credentials are as follows : ");
	
		    System.out.println("Email Id : " + emp.getEmail());
		
		   System.out.println("Password : " + emp.getPassword());
		   
		   System.out.println("-------------------------------------\n\n");
	}

	@Override
	public String generatePassword(int length) {
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialCharacters = "!@#$%^&*(){}?<>?_.+/";
		
		String passwordSet = capitalLetters +smallLetters + specialCharacters + numbers ;
		//System.out.println(passwordSet);
		
	    // Random method
		
		Random rand = new Random();
		String password = "";
	
		for(int i =0; i<8 ; i++) {
			
			password += String.valueOf(passwordSet.charAt(rand.nextInt(passwordSet.length())));
		}
		
		return password;
	}
	

	

}
