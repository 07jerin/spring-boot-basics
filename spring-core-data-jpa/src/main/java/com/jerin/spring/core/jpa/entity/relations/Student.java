package com.jerin.spring.core.jpa.entity.relations;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

	@GeneratedValue
	@Id
	private int studentId;

	private String name;

	@OneToOne
	private Passport passport;

	@ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
	private List<Project> projects;

}
