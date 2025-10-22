package com.example.service.impl;
import com.example.entity.Student;
import com.example.exception.StudentNotFoundException;
import com.example.service.StudentService;
import java.util.ArrayList;
import java.util.List;


/**
 * Concrete implementation of the {@link StudentService} interface.
 * This class uses an in-memory {@code List<Student>} as its data store
 * and implements the CRUD operations using Java Streams for modern,
 * functional-style programming.
 */
public class StudentServiceImpl implements StudentService {
    /**
     * The in-memory data store for Student entities.
     * This list acts as a simple, non-persistent repository.
     */
    private static List<Student> students=new ArrayList<>();

    /**
     * Adds a new student to the in-memory list.
     *
     * @param student The Student object to be added.
     * @return The newly added Student object.
     */
    @Override
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    /**
     * Retrieves all students from the list.
     * @return A list of all existing Student objects, or {@code []} if the list is empty.
     */
    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    /**
     * Retrieves a student by their unique ID using a Stream and functional filtering.
     *
     * @param id The unique ID of the student to retrieve.
     * @return The Student object corresponding to the ID.
     * @throws StudentNotFoundException If no student with the given ID is found.
     */
    @Override
    public Student getStudentById(Integer id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new StudentNotFoundException("Student with id: "+id+" not found"));
    }

    /**
     * Updates the details of an existing student identified by ID.
     * This method first finds the existing student and then updates its fields.
     *
     * @param id The unique ID of the student to be updated.
     * @param updatedStudent The Student object containing the new details (ID, Name, TotalMarks).
     * @return The updated Student object from the list.
     * @throws StudentNotFoundException If no student with the given ID is found.
     */
    @Override
    public Student updateStudentById(Integer id, Student updatedStudent) {
            Student existingStudent = students.stream()
                    .filter(stud -> stud.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found."));
            existingStudent.setId(updatedStudent.getId());
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setTotalMarks(updatedStudent.getTotalMarks());
            return existingStudent;
    }

    /**
     * Deletes a student record identified by their unique ID.
     * @param id The unique ID of the student to delete.
     * Uses Lambda expression to implement functional programming.
     * @return A status message indicating the success or failure of the deletion.
     */
    @Override
    public String deleteStudentById(Integer id) {
        if(students.removeIf(student -> student.getId().equals(id)))
                return "Student with id: "+id+" deleted successfully";
        return "Student with id "+id+" not found";
    }
}
