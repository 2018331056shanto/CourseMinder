//The code is defined within the com.Entity package.
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

@Entity
//The @Table annotation specifies the name of the table
//in the database that corresponds to this entity (in this case, "course").
@Table(name = "course")

//This Entity class has Three field. Each field represents
// a column in a Table. This table has one-to-many relationship 
//with teacher table. It stores the information about Course name and 
//the teachers associated with each course
public class Course {

//	The @Id annotation specifies that the id field is the primary key for the entity
    @Id
//    The @Column annotation specifies the column name in the database table.
    @Column(name = "id")
    private String id;

    @Column(name = "name",unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, teacher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(teacher, other.teacher);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teacher=" + teacher + "]";
	}

	public Course(String id, String name, Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}