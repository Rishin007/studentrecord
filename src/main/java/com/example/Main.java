package com.example;

import com.example.entity.Student;
import com.example.exception.StudentNotFoundException;
import com.example.service.StudentService;
import com.example.service.impl.StudentServiceImpl;

import java.util.Scanner;

public class Main {
    /**
     * An instance of the service layer implementation used to perform CLI-based CRUD operations on students.
     * Initialized as a static field for easy access throughout the main application flow.
     */
    private static StudentService studentService = new StudentServiceImpl();

    /**
     * The main application loop and entry method.
     * It controls the flow of the application, continuously displays the menu,
     * accepts user input, and calls the appropriate service methods.
     */
    static void main() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            IO.println("Hey user, please enter your choice...");
            choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:      // Add a new student
                        IO.println("Enter Student's ID...");
                        Integer studentID = sc.nextInt();
                        IO.println("Enter Student's Name...");
                        String studentName = sc.next();
                        IO.println("Enter Student's Total Marks...");
                        Double totalMarks = sc.nextDouble();
                        IO.println("A new Student has been added...");
                        IO.println(studentService.addStudent(new Student(studentID, studentName, totalMarks)));
                        break;
                    case 2:      // Fetch all students
                        IO.println("The List of the existing Students are : \n" + studentService.getAllStudents());
                        break;
                    case 3:     // Fetch student by ID
                        IO.println("Enter the Student ID :");
                        int id = sc.nextInt();
                        IO.println("The details of the student is : \n" + studentService.getStudentById(id));
                        break;
                    case 4:      // Update an existing student record
                        IO.println("Please enter student ID...");
                        int id2 = sc.nextInt();
                        IO.println("Enter update Student's ID...");
                        Integer updatedStudentID = sc.nextInt();
                        IO.println("Enter Student's Name...");
                        String updatedStudentName = sc.next();
                        IO.println("Enter Student's Total Marks...");
                        Double updatedTotalMarks = sc.nextDouble();
                        IO.println("The student has been updated...");
                        IO.println("The updated student details are : \n" + studentService.updateStudentById(id2,
                                new Student(updatedStudentID, updatedStudentName, updatedTotalMarks)));
                        break;
                    case 5:       // Delete a student record
                        IO.println("Enter the student id to be removed :");
                        int id3 = sc.nextInt();
                        IO.println(studentService.deleteStudentById(id3));
                        break;
                     case 6:      // Exit application
                         System.out.println("Exiting... Goodbye!");
                         System.exit(0);
                         break;
                    default:
                        IO.println("Invalid choice...");
                }
            } catch (StudentNotFoundException e) {         // Catch specific exceptions first
                IO.println(e.getMessage());
            } catch (Exception e) {                       // Catch all other unexpected exceptions
                IO.println(e.getMessage());
            }
        }       // end of do-while loop
        while(choice != 6);
        sc.close();
    }

    /**
     * Displays the main menu options to the user on the console.
     */
    private static void displayMenu() {
        IO.println("\n====== STUDENT RECORD MANAGEMENT SYSTEM ======");
        IO.println("1. TO ADD A NEW STUDENT");
        IO.println("2. TO FETCH ALL THE EXISTING STUDENTS");
        IO.println("3. TO FETCH A STUDENT BY ID");
        IO.println("4. TO UPDATE AN EXISTING STUDENT RECORD");
        IO.println("5. TO DELETE A STUDENT RECORD");
        IO.println("6. Exit");
        IO.println("===================== XXXXX ======================");
    }
}
