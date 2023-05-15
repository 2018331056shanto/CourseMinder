	package com.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//This table has Three columns. Primary key, Students
//and Teachers. This table has two many to one Relationship
//one with Student and another with Course. Thi table
//holds the information about students who has enrolled in 
//any of these course

//This annotation means this class represents a model class
@Entity
//this annotaion defines the name of the Table
	@Table(name = "registration")
	public class Registration {
//This annotaion determines the Primary key in the table
	    @Id
//This annotaion determines the name of the column
	    @Column(name = "id")
	    private String id;
//This annotation determines that this table has Many to One
//relationship with the specific table name Course
	    @ManyToOne
//This annotation make a foreign key in this table and name of that column is studentId	    
	    @JoinColumn(name = "studentId")
	    private Student student;
//This annotation determines that this table has Many to One
//relationship with the specific table name Course
	    @ManyToOne
//This annotation make a foreign key in this table and name of that column is coureseId    

	    @JoinColumn(name = "courseId")
	    private Course course;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		@Override
		public int hashCode() {
			return Objects.hash(course, id, student);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Registration other = (Registration) obj;
			return Objects.equals(course, other.course) && Objects.equals(id, other.id)
					&& Objects.equals(student, other.student);
		}

		@Override
		public String toString() {
			return "Registration [id=" + id + ", student=" + student + ", course=" + course + "]";
		}

		public Registration(String id, Student student, Course course) {
			super();
			this.id = id;
			this.student = student;
			this.course = course;
		}

		public Registration() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

	    // getters and setters
	}

