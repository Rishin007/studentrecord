package com.example.entity;

/**
 * Represents a student entity with core identifying and academic information.
 * This is a standard POJO (Plain Old Java Object)
 */
public class Student {
    private Integer id;
    private String name;
    private Double totalMarks;


    /**
     * Constructs a new Student object with specified details.
     *
     * @param id The unique identifier for the student.
     * @param name The full name of the student.
     * @param totalMarks The student's total marks.
     */
    public Student(Integer id, String name, Double totalMarks) {
        this.id = id;
        this.name = name;
        this.totalMarks = totalMarks;
    }

// --- Getters and Setters ---

    /**
     * Retrieves the unique ID of the student.
     *
     * @return The student's ID.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique ID of the student.
     *
     * @param id The new ID to set.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the student.
     *
     * @return The student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the total marks obtained by the student.
     *
     * @return The student's total marks.
     */
    public Double getTotalMarks() {
        return totalMarks;
    }

    /**
     * Sets the total marks for the student.
     *
     * @param totalMarks The new total marks to set.
     */
    public void setTotalMarks(Double totalMarks) {
        this.totalMarks = totalMarks;
    }

    /**
     * Provides a string representation of the Student object, useful for debugging and logging.
     *
     * @return A formatted string showing all class field values.
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalMarks=" + totalMarks +
                '}'+'\n';
    }
}
