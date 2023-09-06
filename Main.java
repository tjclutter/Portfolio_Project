//import statements
import java.util.Scanner;
import java.util.LinkedList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//declare boolean variable addStudent and initialize to true
		boolean addStudent = true;
		//Create Scanner object
		Scanner scnr = new Scanner(System.in);
		//create linked list that will contain Student objects
		LinkedList<Student> studentList = new LinkedList<Student>();
		
		
		//iterate while loop until addStudent is false
		while(addStudent) {
			
			//prompt user to enter name, address, and GPA
			//Store user input in variables
			System.out.println("Enter student name: ");
			String name = scnr.nextLine();
			System.out.println("Enter student address");
			String address = scnr.nextLine();
			System.out.println("Enter student GPA");
			double GPA = scnr.nextDouble();
			
			//ask user if they want to add another student
			System.out.println("Do you want to add another studen y/n: ");
			
			//read and store users answer
			char anotherStudent = scnr.next().charAt(0);
			//clear scanner object for new input
			scnr.nextLine();
			
			//if user wants to add another student or not
			//change the variable addStudent accordingly
			if (anotherStudent == 'y') {
				addStudent = true;
			}else {
				addStudent = false;
			}
			
			//create new student object using constructor
			Student student = new Student(name, address, GPA);
			//add new student object to list
			studentList.add(student);
		}
		
		//declare two student object variables and a moveIndex variable
		Student moveStudent;
		Student compareStudent;
		int moveIndex;
		
		//iterate through student list using a for loop
		for(int i = 0; i < studentList.size(); i++) {
			
			//store in moveStudent the Student in the list at index i
			moveStudent = studentList.get(i);
			//set moveIndex to i
			moveIndex = i;
			
			//iterate through list again but using j
			for(int j = i; j < studentList.size(); j++) {
				
				//set variable compareStudent to student in the list at index j
				compareStudent = studentList.get(j);
				//compare two students by name in if statement
				if (moveStudent.getName().compareTo((compareStudent.getName())) >0) {
					//set moveStudent to compare student and moveIndex to j
					moveStudent = compareStudent;
					moveIndex = j;
				}
				
			}
			// if moveIndex doesn't equal i swap student locations in list
			if (moveIndex != i) {
				System.out.println(moveStudent.getName());
				studentList.remove(moveIndex);
				studentList.add(i,moveStudent);
				
				
			}
		}
		//create a FileOutputStream and PrintWriter object
		FileOutputStream FOS = new FileOutputStream("StudentList.txt");
		PrintWriter PW = new PrintWriter(FOS);
		//use for loop to iterate through student list
		for(int i = 0; i < studentList.size(); i++) {
			//print students information to the text file "StudentList.txt" 
			Student printStudent = studentList.get(i);
			PW.println(printStudent.getName() + " " + printStudent.getAddress() + " " + printStudent.getGPA());
		}
		//flush print writer object and close file output stream object
		PW.flush();
		FOS.close();
	}

}


