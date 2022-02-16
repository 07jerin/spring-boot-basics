package com.jerin.spring.core.jpa.entity.relations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {

	@Id
	@GeneratedValue
	private int taskId;

	private String name;

	@ManyToOne
//	@JoinColumn(name = "project_id")
	private Project project;
}
