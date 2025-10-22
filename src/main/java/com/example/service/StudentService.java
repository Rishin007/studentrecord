package com.example.service;
import com.example.entity.Student;
import java.util.List;

/**
 * Service interface for managing Student operations.
 * Defines the contract for CRUD (Create, Read, Update, Delete) operations
 * on the Student entity.
 */

public interface StudentService {
    /**
     * Adds a new Student record to the data store.
     *
     * @param student The Student object to be added.
     * @return The newly created Student object, often including a generated ID.
     */
    Student addStudent(Student student);

    /**
     * Retrieves a Student record by their unique identifier.
     *
     * @param id The unique ID of the student to retrieve.
     * @return The Student object corresponding to the ID, or null/throws an exception if not found.
     */
    Student getStudentById(Integer id);

    /**
     * Retrieves a list of all Student records available in the data store.
     *
     * @return A List containing all Student objects. Returns an empty list if no students are found.
     */
    List<Student> getAllStudents();

    /**
     * Updates the details of an existing Student record identified by ID.
     *
     * @param id The unique ID of the student to be updated.
     * @param student The Student object containing the new details to update.
     * @return The updated Student object.
     */
    Student updateStudentById(Integer id,Student student);

    /**
     * Deletes a Student record identified by their unique ID.
     *
     * @param id The unique ID of the student to delete.
     * @return A status message indicating the success or failure of the deletion.
     */
    String deleteStudentById(Integer id);
}
