package com.Entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_course")
public class TeacherCourse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherCourseId;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

	public int getTeacherCourseId() {
		return teacherCourseId;
	}

	public void setTeacherCourseId(int teacherCourseId) {
		this.teacherCourseId = teacherCourseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, teacher, teacherCourseId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherCourse other = (TeacherCourse) obj;
		return Objects.equals(course, other.course) && Objects.equals(teacher, other.teacher)
				&& teacherCourseId == other.teacherCourseId;
	}

	@Override
	public String toString() {
		return "TeacherCourse [teacherCourseId=" + teacherCourseId + ", course=" + course + ", teacher=" + teacher
				+ "]";
	}

	public TeacherCourse(int teacherCourseId, Course course, Teacher teacher) {
		super();
		this.teacherCourseId = teacherCourseId;
		this.course = course;
		this.teacher = teacher;
	}

	public TeacherCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    // constructors, getters, setters
}
