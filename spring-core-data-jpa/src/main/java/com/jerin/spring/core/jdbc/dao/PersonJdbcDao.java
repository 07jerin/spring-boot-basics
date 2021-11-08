package com.jerin.spring.core.jdbc.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jerin.spring.core.jdbc.entity.JdbcPerson;

import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class PersonJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<JdbcPerson> customRowMapper = (rs, i) -> {

		JdbcPerson p = new JdbcPerson();
		String name = rs.getString("name");
		int id = rs.getInt("id");
		p.setIdName(id + " - " + name);
		return new JdbcPerson();
	};

	public List<JdbcPerson> findAll() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<JdbcPerson>(JdbcPerson.class));
	}

	public JdbcPerson findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id = ? ", new Object[] { id },
				new int[] { Types.INTEGER }, new BeanPropertyRowMapper<JdbcPerson>(JdbcPerson.class));

	}

	public JdbcPerson findByIdCustomRowMapper(int id) {
		return jdbcTemplate.queryForObject("select * from person where id = ? ", new Object[] { id },
				new int[] { Types.INTEGER }, customRowMapper);
	}

	public int deletById(int id) {
		return jdbcTemplate.update("delete from person where id = ? ", new Object[] { id });
	}

	public int updateName(JdbcPerson person) {
		return jdbcTemplate.update("update person set name= ? where id = ?",
				new Object[] { person.getName(), person.getId() }, new int[] { Types.VARCHAR, Types.INTEGER });
	}

	public int insert(JdbcPerson person) {
		return jdbcTemplate.update("insert into person (id, name, location, birth_date) values(?, ?, ?, ?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(), person.getBirth_date() });
	}

}
