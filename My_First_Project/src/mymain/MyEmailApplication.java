package mymain;

import java.util.Scanner;

import emailsevices.CredentialServices;
import myinterface.ECredentials;
import mymodel.MyEmployee;

public class MyEmailApplication {

	public static void main(String[] args) {
		MyEmailApplication em = new MyEmailApplication();
		Scanner sc = new Scanner(System.in);
		ECredentials credential = new CredentialServices("greatlearning.com");
		int option = 0;
		do {	
			System.out.println("1. Technical");
			System.out.println("2. Admin");
			System.out.println("3. Human Resource");
			System.out.println("4. Legal");
			System.out.println("Enter Department Name : ");
			option = sc.nextInt();
	
		
			switch (option) {
			case 1:
				em.generateEmailAndPassword(sc, credential, "tech");
				break;
			case 2:
				em.generateEmailAndPassword(sc, credential, "admin");
				break;
			case 3:
				em.generateEmailAndPassword(sc, credential, "hr");
				break;
			case 4:
				em.generateEmailAndPassword(sc, credential, "leg");
				break;
			default:
				System.out.println("Sorry! you have entered an invalid option!");
				break;
			}
		} while (option != 0);
		sc.close();
	}

	
	private void generateEmailAndPassword(Scanner sc, ECredentials credential, String department) {
		System.out.println("Enter FirstName : ");
		String firstName = sc.next();
		System.out.println("Enter LastName : ");
		String lastName = sc.next();
		MyEmployee employee = new MyEmployee(firstName, lastName);
		employee.setDepartment(department);
		employee.setEmail(credential.generateEmailAddress(employee));
		employee.setPassword(credential.generatePassword(8));
		credential.showCredentials(employee);
	}

}
