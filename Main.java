import java.util.Scanner;
import java.util.LinkedList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean addStudent = true;
		Scanner scnr = new Scanner(System.in);
		LinkedList<Student> studentList = new LinkedList<Student>();
		
		
		
		while(addStudent) {
			System.out.println("Enter student name: ");
			String name = scnr.nextLine();
			System.out.println("Enter student address");
			String address = scnr.nextLine();
			System.out.println("Enter student GPA");
			double GPA = scnr.nextDouble();
			System.out.println("Do you want to add another studen y/n: ");
			char anotherStudent = scnr.next().charAt(0);
			scnr.nextLine();
			if (anotherStudent == 'y') {
				addStudent = true;
			}else {
				addStudent = false;
			}
			Student student = new Student(name, address, GPA);
			studentList.add(student);
		}
		Student moveStudent;
		Student compareStudent;
		int moveIndex;
		for(int i = 0; i < studentList.size(); i++) {
			moveStudent = studentList.get(i);
			moveIndex = i;
			for(int j = i; j < studentList.size(); j++) {
				compareStudent = studentList.get(j);
				if (moveStudent.getName().compareTo((compareStudent.getName())) >0) {
					moveStudent = compareStudent;
					moveIndex = j;
				}
				
			}
			if (moveIndex != i) {
				System.out.println(moveStudent.getName());
				studentList.remove(moveIndex);
				studentList.add(i,moveStudent);
				
				
			}
		}
		
		FileOutputStream FOS = new FileOutputStream("StudentList.txt");
		PrintWriter PW = new PrintWriter(FOS);
		for(int i = 0; i < studentList.size(); i++) {
			Student printStudent = studentList.get(i);
			PW.println(printStudent.getName() + " " + printStudent.getAddress() + " " + printStudent.getGPA());
		}
		PW.flush();
		FOS.close();
	}

}


