package com.jerin.spring.core.jpa.entity.relations;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Passport {

	@Id
	@GeneratedValue
	private int passportId;

	private String name;

	@OneToOne(mappedBy = "passport", fetch = FetchType.LAZY)
	private Student student;

}
