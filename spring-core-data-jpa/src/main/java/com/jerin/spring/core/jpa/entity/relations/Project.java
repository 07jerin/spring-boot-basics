package com.jerin.spring.core.jpa.entity.relations;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<Task> tasks;

	@ManyToMany
	private List<Student> students;

}
