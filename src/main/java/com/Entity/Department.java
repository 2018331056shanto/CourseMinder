package com.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//This table has Two column. Department name 
// and  id. This table contains the infromation
//about the department name and the id associated 
//with it
@Entity
// Determines  Name of the table 
@Table(name = "department")
public class Department {
// Its for primary key in Department Table
    @Id
//    each column attribute specify the name of a column
    @Column(name = "id")
    private String id;

    @Column(name = "name",nullable = false)
    private String name;

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

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	public Department(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
