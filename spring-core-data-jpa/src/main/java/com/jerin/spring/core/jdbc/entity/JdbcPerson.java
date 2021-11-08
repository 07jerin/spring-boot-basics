package com.jerin.spring.core.jdbc.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JdbcPerson {

	private int id;
	private String name;
	private String location;
	private LocalDate birth_date;
	
	private String idName;

}
