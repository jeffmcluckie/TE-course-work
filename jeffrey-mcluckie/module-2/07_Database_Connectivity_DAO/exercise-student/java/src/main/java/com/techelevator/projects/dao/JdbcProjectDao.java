package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sql = "SELECT project_id, name, from_date, to_date " +
				"FROM project WHERE project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		if ( results.next() ) {
			project = mapRowToProject(results);
		}
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projectList = new ArrayList<>();
		String sql = "SELECT project_id, name, from_date, to_date FROM project;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
			Project project = mapRowToProject(results);
			projectList.add(project);
		}

		return projectList;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date ) " +
				"VALUES (?, ?, ?) RETURNING project_id;";
		Long projectId = jdbcTemplate.queryForObject(sql, Long.class,
				newProject.getName(), newProject.getFromDate(), newProject.getToDate());
		// By fetching from the database again, any updates from other users (not relevant on insert)
		// or default values will be set in the object
		return getProject(projectId);
	}

	@Override
	public void deleteProject(Long projectId) {
		String sqlProjectEmployee = "DELETE FROM project_employee WHERE project_id = ?;";
		jdbcTemplate.update(sqlProjectEmployee, projectId);
		String sqlProject = "DELETE FROM project WHERE project_id = ?;";
		jdbcTemplate.update(sqlProject, projectId);
	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();

		Long projectId = rowSet.getLong("project_id");
		project.setId( projectId );


		project.setName( rowSet.getString("name") );
		if(rowSet.getDate("from_date") != null) {
			project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		}
		if(rowSet.getDate("to_date") != null) {
			project.setToDate(rowSet.getDate("to_date").toLocalDate());
		}
		return project;
	}
	

}
