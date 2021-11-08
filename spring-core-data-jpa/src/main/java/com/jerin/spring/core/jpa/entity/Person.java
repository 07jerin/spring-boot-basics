package com.jerin.spring.core.jpa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
@NamedQuery(name="find_all_person", query = "select p from Person p ")
public class Person {

	@Id
	@GeneratedValue(generator = "person_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "person_id_seq", sequenceName = "person_id_seq", initialValue = 10)
	private int id;
	
	private String name;
	
	private String location;
	
	@Column(name = "birth_date")
	private LocalDate dob;

}
