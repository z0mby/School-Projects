package chap10;

/*
 * COP3003 lab 2
 * Created 9/7/14
 * Last Updated 9/10/14
 * 
 * The purpose of this program is demonstrate uses of inheritance and 
 * using other class's private members through public methods.
 */

//Driver class
public class Driver {
	/*
	 * Main calls GradTA's constructor which in turns calls
	 * other constructors through the use of super.
	 * After all of the readData methods are finished, main calls GradTA's print function
	 * which in turn calls other class print functions
	 */
	public static void main(String args[]){
		GradTA ta = new GradTA();
		ta.print();
	}
} // end driver class

package chap10;

import java.util.Scanner;

public class GradTA extends GradStudent {
	private String taCourse;
	private String taInstructor;
	private Date hireDate;
	
	/*
	 * GradTA's Constructor. Calls its parent's constructor(GradStudent)
	 * and runs its constructor. After that class finishes, it runs read data.
	 */
	public GradTA(){
		super();
		readData();
	}
	
	private void readData(){
		Scanner sc = new Scanner(System.in);
		// If user entered 'm', use male pronouns
		if (gender == 'm'){
			System.out.print("Please input his TA course: ");
			taCourse = sc.nextLine();
			System.out.print("Please input his TA instructor: ");
			taInstructor = sc.nextLine();
			System.out.print("Please input his hire date: ");
			// JobDate is an object of Date()
			Date jobDate = new Date();
			// and is assigned to hiredate.
			hireDate = jobDate;
		}else{
			// else female pronouns.
			System.out.print("Please input her TA course: ");
			taCourse = sc.nextLine();
			System.out.print("Please input her TA instructor: ");
			taInstructor = sc.nextLine();
			System.out.print("Please input her hire date: ");
			// Same thing here.
			Date jobDate = new Date();
			hireDate = jobDate;
		}
	}
	
	public void print(){
		// calls GradStudent's print function.
		super.print();
		if (gender == 'm'){
			System.out.println("His TA course is " + taCourse + ".");
			System.out.println("His TA instructor is " + taInstructor + ".");
			System.out.print("His hire date is ");
			hireDate.print();
		}else{
			System.out.println("Her TA course is " + taCourse + ".");
			System.out.println("Her TA instructor is " + taInstructor + ".");
			System.out.print("Her hire date is ");
			hireDate.print();
		}
	}
} // end grad TA class


package chap10;

import java.util.Scanner;

public class GradStudent extends Student {
	private String researchTopic;
	private String advisor;
	
	/*
	 * GradStudent's constructor. Super calls GradStudent's parent constructor (Which is student)
	 * which makes student run its readData(). After student class is finished,
	 * GradStudent will run its readData().
	 */
	public GradStudent(){
		super();
		readData();
	}
	
	private void readData(){
		Scanner sc = new Scanner(System.in);
		// If user entered 'm', use male pronouns.
		if (gender == 'm'){
			System.out.print("Please input his research topic: ");
			researchTopic = sc.nextLine();
			System.out.print("Please input his research advisor: ");
			advisor = sc.nextLine();
		// Else use female pronouns.	
		}else{
			System.out.print("Please input her research topic: ");
			researchTopic = sc.nextLine();
			System.out.print("Please input her research advisor: ");
			advisor = sc.nextLine();
		}
	}
	
	public void print(){
		// Calls parent's print method. (Student)
		super.print();
		// Use male pronouns if m
		if (gender == 'm'){
			System.out.println("\nHis research topic is " + researchTopic + ".");
			System.out.println("His advisor is " + advisor + ".");
		// else female pronouns.	
		}else{
			System.out.println("\nHer research topic is " + researchTopic + ".");
			System.out.println("Her advisor is " + advisor + ".");
		}
	}
} // End gradstudent class

package chap10;
// import declarations
import java.util.Scanner;

public class Student {
	private String name;
	private int ssn;
	private int numOfCourses;
	private Date birthdate;
	protected char gender;
	
	// Student's constructor. readData() is called.
	public Student(){
		readData();
	}
	
	private void readData(){
		// Input/output 
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input the name: ");
		name = sc.nextLine();
		System.out.print("Please input the ssn: ");
		ssn = sc.nextInt();
		System.out.print("Male/Female (m/f): ");
		gender = sc.next().charAt(0);
		// if user enters 'm', male specific pronouns are used
		if (gender == 'm'){
			System.out.print("How many courses is he taking: ");
			numOfCourses = sc.nextInt();
			System.out.print("Please input his birth date: ");
			// This creates an object of date... 
			Date bDay = new Date();
			// Which in turn is assigned to birthdate.
			birthdate = bDay;
		// Else use female specific pronouns.	
		}else {
			System.out.print("How many courses is she taking: ");
			numOfCourses = sc.nextInt();
			System.out.print("Please input her birth date: ");
			// Same thing happens here.
			Date bDay = new Date();
			birthdate = bDay;
		}
		
		
	}
	
	public void print(){
		System.out.println("\nThe information you input was ");
		System.out.println(name + "'s ssn is " + ssn + ".");
		if (gender == 'm'){
			System.out.println("He is taking " + numOfCourses + " courses.");
			System.out.print("His birth date is ");
			// Birthdate now calls date's print method.
			birthdate.print();
		}else{
			System.out.println("She is taking " + numOfCourses + " courses.");
			System.out.print("Her birth date is " );
			// Same thing here.
			birthdate.print();
		}
	}
} // End Student Class

package chap10;

// import declaration
import java.util.Scanner;

public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date(){
		readData();
	}
	
	private void readData(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\tPlease input the month: ");
		month = sc.nextInt();
		System.out.print("\tPlease input the day: ");
		day = sc.nextInt();
		System.out.print("\tPlease input the year: ");
		year = sc.nextInt();
	}
	
	public void print(){
		System.out.print("" + month +"/" + day + "/" + year);
	}
} // End Date Class
